import java.util.Scanner;
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

        ClubSearch clubSearch = new ClubSearch(PlayerDB);

        if(ClubSearchMenuOption == 1) {
            String clubToBeSearched = clubNamePrompt();
            
            if (clubSearch.searchByName(clubToBeSearched)) {
                double maxSalary = clubSearch.maxSalaryInCLub(clubToBeSearched);

                System.out.println("The maximum weekly salary at the club " + clubToBeSearched + "is: ");
                System.out.printf("%f\n", maxSalary);
                System.out.println("The player(s) with maximum salary:");

                clubSearch.printPlayerInClubBySalary(maxSalary, clubToBeSearched);
            } else {
                noSuchClubPrompt();
            }
            
            return true;

        } else if(ClubSearchMenuOption == 2) {
            String clubToBeSearched = clubNamePrompt();

            if (clubSearch.searchByName(clubToBeSearched)) {
                double maxAge = clubSearch.maxAgeInCLub(clubToBeSearched);

                System.out.println("The maximum age of players at the club " + clubToBeSearched + "is: ");
                System.out.printf("%d\n", maxAge);
                System.out.println("The player(s) with maximum age:");

                clubSearch.printPlayerInClubByAge(maxAge, clubToBeSearched);
            } else {
                noSuchClubPrompt();
            }
            
            return true;

        } else if(ClubSearchMenuOption == 3) {
            String clubToBeSearched = clubNamePrompt();

            if (clubSearch.searchByName(clubToBeSearched)) {
                double maxHeight = clubSearch.maxHeightInCLub(clubToBeSearched);

                System.out.println("The maximum height of players at the club " + clubToBeSearched + "is: ");
                System.out.printf("%f\n", maxHeight);
                System.out.println("The player(s) with maximum height:");

                clubSearch.printPlayerInClubByHeight(maxHeight, clubToBeSearched);
            } else {
                noSuchClubPrompt();
            }
            
            return true;

        } else if(ClubSearchMenuOption == 4) {
            String clubToBeSearched = clubNamePrompt();

            if (clubSearch.searchByName(clubToBeSearched)) {
                double totalSalary = clubSearch.totalYearlySalaryClub(clubToBeSearched);

                System.out.println("The total yearly salary of players at the club " + clubToBeSearched + "is: ");
                System.out.printf("%.2f\n", totalSalary);

            } else {
                noSuchClubPrompt();
            }

            return true;

        } else if(ClubSearchMenuOption == 5) {
            return false;

        } else {
            System.out.println("Please choose a correct option");
            System.out.println("=========================================================================================");

            return true;
        }
    }

    public String clubNamePrompt () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the club for its players to be searched:");
        return input.nextLine();
    }
    
    public void noSuchClubPrompt () {
        System.out.println("No such club with this name");
        System.out.println("=========================================================================================");
    }
}
