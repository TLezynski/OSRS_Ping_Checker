/**
 * OSRS Ping Checker
 * Created by Trevor Lezynski on 9/30/2018.
 */
public class main {

    public static void main(String[] args) {
        WorldList wList = new WorldList();
        wList.populateWithDefaultWorlds();
        for (World w: wList.getWorldList()) {
            w.ping();
        }
        wList.sortByPing();
        System.out.println(wList);
    }
}
