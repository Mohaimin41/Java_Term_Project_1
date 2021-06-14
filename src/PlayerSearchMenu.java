import java.util.List;

public class PlayerSearchMenu {

    public PlayerSearchMenu() {
    }

    public void writeMenu() {
        System.out.println("Player Searching Options:");
        System.out.println("(1) By Player Name");
        System.out.println("(2) By Club and Country");
        System.out.println("(3) By Position");
        System.out.println("(4) By Salary Range");
        System.out.println("(5) Country-wise player count");
        System.out.println("(6) Back to Main Menu");
    }

    public boolean processMenu(int playerSearchOption, List<Player> PlayerDB) {
        if(playerSearchOption == 1) {
            return true;
        } else if(playerSearchOption == 2) {
            return true;
        } else if(playerSearchOption == 3) {
            return true;
        } else if(playerSearchOption == 4) {
            return true;
        } else if(playerSearchOption == 5) {
            return true;
        } else if(playerSearchOption == 6) {
            return false;
        } else {
            System.out.println("Please choose a correct option");
            return true;
        }
    }
}