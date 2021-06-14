import java.util.List;

public class ClubSearchMenu {
    List<Player> PlayerDB;

    public ClubSearchMenu() {
    }

    public void writeMenu() {
        System.out.println("Club Searching Options:");
        System.out.println("(1) Player(s) with the maximum salary of a club");
        System.out.println("(2) Player(s) with the maximum age of a club");
        System.out.println("(3) Player(s) with the maximum height of a club");
        System.out.println("(4) Total yearly salary of a club");
        System.out.println("(5) Back to Main Menu");
    }
    
    public boolean processMenu(int ClubSearchMenuOption, List<Player> PlayerDB) {
        if(ClubSearchMenuOption == 1) {
            return true;
        } else if(ClubSearchMenuOption == 2) {
            return true;
        } else if(ClubSearchMenuOption == 3) {
            return true;
        } else if(ClubSearchMenuOption == 4) {
            return true;
        } else if(ClubSearchMenuOption == 5) {
            return false;
        } else {
            System.out.println("Please choose a correct option");
            return true;
        }
    }
}
