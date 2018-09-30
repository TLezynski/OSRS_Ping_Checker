import java.util.ArrayList;
import java.util.Collections;

/**
 * OSRS Ping Checker
 * Created by Trevor Lezynski on 2/13/2018.
 */
public class WorldList{

    private ArrayList<World> worldList;

    // Constructor for the world list
    public WorldList(){
        worldList = new ArrayList<>();
    }

    // Getter for the world list
    public ArrayList<World> getWorldList() {
        return worldList;
    }

    // Adds a World w to the list
    public void addWorld(World w) {
        worldList.add(w);
    }

    // Removes a World w from the list
    public void removeWorld(World w){
        worldList.remove(w);
    }

    // Sort the worlds by ascending ping
    public void sortByPing() {
        Collections.sort(getWorldList());
    }

    // Print each world in the list and its ping
    @Override
    public String toString(){
        String s = "";
        for(World w : getWorldList()){
            s += w.getNumber() + " // " + w.getPing() + "ms\n";
        }
        return s;
    }

    // Populates the world list with the default worlds
    public void populateWithDefaultWorlds(){
        // Initial worlds are 301 - 424, some of which don't exists.
        for (int worldNumber=1; worldNumber < 125; worldNumber++){
            switch (worldNumber) {
                case 63:
                case 64:
                case 71:
                case 72:
                case 79:
                case 80:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 104:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 113:
                case 114:
                    continue;
            }
            this.addWorld(new World(worldNumber));
        }
    }
}
