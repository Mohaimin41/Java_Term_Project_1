package player_database.menu;

import java.util.Scanner;
import java.util.List;

import player_database.database.Player;
//import player_database.database.PlayerDatabase;
import player_database.search.ClubSearch;

public class ClubSearchMenu extends ClubSearch implements InputOutputFormatter {

    public ClubSearchMenu(List<Player> PlayerDB) {
        super(PlayerDB);
    }

    public void writeMenu() {
        System.out.println("Club Searching Options:");
        System.out.println("(1) Player(s) with the maximum salary of a club");
        System.out.println("(2) Player(s) with the maximum age of a club");
        System.out.println("(3) Player(s) with the maximum height of a club");
        System.out.println("(4) Total yearly salary of a club");
        System.out.println("(5) Back to Main Menu");
    }

    public boolean processMenu(int ClubSearchMenuOption) {

        if (ClubSearchMenuOption == 1) {
            String clubToBeSearched = clubNamePrompt();

            if (searchClubByName(clubToBeSearched)) {
                double maxSalary = maxSalaryInCLub(clubToBeSearched);

                System.out.println("The maximum weekly salary at the club '" + clubToBeSearched + "' is: ");
                System.out.printf("%.2f\n", maxSalary);
                System.out.println("The player(s) with maximum salary:");

                printPlayerInClubBySalary(maxSalary, clubToBeSearched);
            } else {
                noSuchClubPrompt();
            }

            return true;

        } else if (ClubSearchMenuOption == 2) {
            String clubToBeSearched = clubNamePrompt();

            if (searchClubByName(clubToBeSearched)) {
                int maxAge = maxAgeInCLub(clubToBeSearched);

                System.out.println("The maximum age of the players at the club '" + clubToBeSearched + "' is: ");
                System.out.printf("%d years\n", maxAge);
                System.out.println("The player(s) with maximum age:");

                printPlayerInClubByAge(maxAge, clubToBeSearched);
            } else {
                noSuchClubPrompt();
            }

            return true;

        } else if (ClubSearchMenuOption == 3) {
            String clubToBeSearched = clubNamePrompt();

            if (searchClubByName(clubToBeSearched)) {
                double maxHeight = maxHeightInCLub(clubToBeSearched);

                System.out.println("The maximum height of players at the club '" + clubToBeSearched + "' is: ");
                System.out.printf("%.2f meter\n", maxHeight);
                System.out.println("The player(s) with maximum height:");

                printPlayerInClubByHeight(maxHeight, clubToBeSearched);
            } else {
                noSuchClubPrompt();
            }

            return true;

        } else if (ClubSearchMenuOption == 4) {
            String clubToBeSearched = clubNamePrompt();

            if (searchClubByName(clubToBeSearched)) {
                double totalSalary = totalYearlySalaryClub(clubToBeSearched);

                System.out.println("The total yearly salary of players at the club '" + clubToBeSearched + "' is: ");
                System.out.printf("%.2f\n", totalSalary);

            } else {
                noSuchClubPrompt();
            }

            return true;

        } else if (ClubSearchMenuOption == 5) {
            return false;

        } else {
            chooseCorrectOption();

            return true;
        }
    }

    public String clubNamePrompt() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the club for its players to be searched:");
        return input.nextLine();
    }
}
