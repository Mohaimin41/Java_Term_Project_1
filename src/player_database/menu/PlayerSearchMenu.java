package player_database.menu;

import java.util.Scanner;
import java.util.List;

//import player_database.database.PlayerDatabase;
import player_database.search.PlayerSearch;
import player_database.database.Player;

public class PlayerSearchMenu extends PlayerSearch implements InputOutputFormatter {

    public PlayerSearchMenu(List<Player> PlayerDB) {
        super(PlayerDB);
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

    public boolean processMenu(int playerSearchOption) {
        Scanner input = new Scanner(System.in);

        if (playerSearchOption == 1) {

            System.out.println("Enter the name of the player to be searched: ");
            String searchString = input.nextLine();

            if (searchByName(searchString)) {
                returnSearchedPlayer(searchString).display();
            } else {
                System.out.println("No such player with this name");
                horizontalLine();
            }

            return true;

        } else if (playerSearchOption == 2) {
            System.out.println("Enter the country to be searched:");
            String country = input.nextLine();
            System.out.println("Enter the club to be searched");
            String club = input.nextLine();

            if (club.equals("ANY")) {
                printPlayerList(searchByCountry(country));
            } else {
                printPlayerList(searchByClubCountry(country, club));
            }

            return true;

        } else if (playerSearchOption == 3) {
            System.out.println("Enter the position to be searched:");
            String Position = input.nextLine();
            printPlayerList(searchByPosition(Position));

            return true;

        } else if (playerSearchOption == 4) {
            System.out.println("Enter the weekly salary range to be searched:");

            System.out.println("Lower Bound:");
            double low = getDoubleFromUser();
            System.out.println("Upper Bound:");
            double high = getDoubleFromUser();

            printPlayerList(searchBySalaryRange(low, high));

            return true;

        } else if (playerSearchOption == 5) {
            countryStat();
            return true;

        } else if (playerSearchOption == 6) {
            return false;

        } else {
            chooseCorrectOption();
            return true;
        }
    }
}
