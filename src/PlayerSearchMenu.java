import java.util.Scanner;
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
        Scanner input = new Scanner(System.in);
        PlayerSearch playerSearch = new PlayerSearch(PlayerDB);

        if(playerSearchOption == 1) {

            System.out.println("Enter the name of the player to be searched: ");
            String searchString = input.nextLine();

            if (playerSearch.searchByName(searchString)) {
                playerSearch.returnSearchedPlayer(searchString).display();
            } else {
                System.out.println("No such player with this name");
                System.out.println("=========================================================================================");
            }

            return true;

        } else if(playerSearchOption == 2) {
            System.out.println("Enter the country to be searched:");
            String country = input.nextLine();
            System.out.println("Enter the club to be searched");
            String club = input.nextLine();

            if(club.equals("ANY")) {
                playerSearch.searchByCountry(country);
            } else {
                playerSearch.searchByClubCountry(country, club);
            }

            return true;

        } else if(playerSearchOption == 3) {
            System.out.println("Enter the position to be searched");
            String Position = input.nextLine();
            playerSearch.searchByPosition(Position);

            return true;

        } else if(playerSearchOption == 4) {
            System.out.println("Enter the weekly salary range to be searched:");

            System.out.println("Lower Bound:");
            double low = input.nextDouble();
            System.out.println("Upper Bound");
            double high = input.nextDouble();

            playerSearch.searchBySalaryRange(low, high);

            return true;

        } else if(playerSearchOption == 5) {
            playerSearch.countryStat();
            return true;

        } else if(playerSearchOption == 6) {
            return false;

        } else {
            System.out.println("Please choose a correct option:");
            return true;
        }
    }
}