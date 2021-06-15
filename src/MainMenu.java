import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public MainMenu() {
    }

    public void MenuWrite() {
        System.out.println("Main Menu");
        System.out.println("(1) Search Players");
        System.out.println("(2) Search Clubs");
        System.out.println("(3) Add Players");
        System.out.println("(4) Exit System");
    }

    public boolean MenuProcess (int MenuOption, List<Player> PlayerDB, FileIO PlayerFile) throws Exception {
        Scanner input = new Scanner(System.in);

        if (MenuOption == 1 ) {
            PlayerSearchMenu playerSearchMenu =  new PlayerSearchMenu();

            while (true) {
                playerSearchMenu.writeMenu();
                int PlayerSearchMenuOption = input.nextInt();

                if(!playerSearchMenu.processMenu(PlayerSearchMenuOption, PlayerDB)) {
                    break;
                }
            }
            return true;

        } else if (MenuOption == 2) {
            ClubSearchMenu clubSearchMenu = new ClubSearchMenu();

            while (true) {
                clubSearchMenu.writeMenu();
                int clubSearchMenuOption = input.nextInt();

                if(!clubSearchMenu.processMenu(clubSearchMenuOption, PlayerDB)) {
                    break;
                }
            }
            return true;

        } else if (MenuOption == 3) {
            AddPlayer addPlayer = new AddPlayer(PlayerDB);

            System.out.println("Enter the details of the player below:");

            Player playerToBeAdded = addPlayer.inputPlayer();

            if (addPlayer.isNamePresent(playerToBeAdded)) {
                System.out.println("There is already a player present with this name");
            } else {
                if (addPlayer.hasClubSpace(playerToBeAdded)) {
                    addPlayer.addPlayer(playerToBeAdded);
                } else {
                    System.out.println("The club" + playerToBeAdded.getClub() + "already has 7 players, no more player can be added");
                }
            }

            return true;

        } else if (MenuOption == 4) {
            PlayerFile.writeToFile(PlayerDB);
            return false;

        } else {
            System.out.println("Please choose a correct option:");
            System.out.println("=========================================================================================");
            return true;
        }
    }
}

