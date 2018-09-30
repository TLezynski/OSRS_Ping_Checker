import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * OSRS Ping Checker
 * Created by Trevor Lezynski on 2/13/2018.
 */
public class World implements Comparable<World>{

//    The World object has a few attributes that are specific to each world.

    private int number;
    private int ping;

    // Constructor for the World class.
    public World(int number){
        this.number = number;
    }

    // Getter for the number attribute
    public int getNumber() {
        return number;
    }

    // Getter for the ping attribute
    public int getPing() {
        return ping;
    }

    // Compare method for the sorting function.
    @Override
    public int compareTo(World w){
        return Integer.compare(getPing(), w.getPing());
    }

    // Pings this world and set the ping attribute to the response.
    public void ping() {
        // Only ping the destination once
        String ip = "oldschool" + getNumber() + ".runescape.com";
        String pingCmd = "ping -n 1 " + ip;
        try{
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd);
            System.out.println("Pinging " + ip);

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                // Look for the line containing "Average"
                // Parse that line to get the actual number that is the average
                //
                // ex: "Minimum = 24ms, Maximum = 24ms, Average = 24ms"
                // This code extracts the number 24 that comes after average using sub-strings and indexing
                if(inputLine.contains("Average")){
                    String[] splitOnComma = inputLine.split(",");
                    String parseForAverage = splitOnComma[2];
                    String averagePing = parseForAverage.substring(parseForAverage.lastIndexOf(" "), parseForAverage.lastIndexOf("m"));
                    averagePing = averagePing.substring(1);
                    // Set the attribute ping to the proper number
                    this.ping = Integer.parseInt(averagePing);
                }
            }
            in.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
