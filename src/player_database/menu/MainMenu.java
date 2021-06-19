package player_database.menu;

import java.util.List;
import java.util.Scanner;

import player_database.database.*;

public class MainMenu implements InputOutputFormatter {
    List<Player> PlayerDB;
    FileIO PlayerFile;

    public MainMenu(List<Player> PlayerDB, FileIO PlayerFile) {
        this.PlayerDB = PlayerDB;
        this.PlayerFile = PlayerFile;
    }

    public void MenuWrite() {
        System.out.println("Main Menu");
        System.out.println("(1) Search Players");
        System.out.println("(2) Search Clubs");
        System.out.println("(3) Add Players");
        System.out.println("(4) Exit System");
    }

    public boolean MenuProcess(int MenuOption) throws Exception {
        Scanner input = new Scanner(System.in);

        if (MenuOption == 1) {
            PlayerSearchMenu playerSearchMenu = new PlayerSearchMenu(PlayerDB);

            while (true) {
                playerSearchMenu.writeMenu();
                int PlayerSearchMenuOption = input.nextInt();

                if (!playerSearchMenu.processMenu(PlayerSearchMenuOption)) {
                    break;
                }
            }
            return true;

        } else if (MenuOption == 2) {
            ClubSearchMenu clubSearchMenu = new ClubSearchMenu(PlayerDB);

            while (true) {
                clubSearchMenu.writeMenu();
                int clubSearchMenuOption = input.nextInt();

                if (!clubSearchMenu.processMenu(clubSearchMenuOption)) {
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

                    System.out.println("The player " + playerToBeAdded.getName() + " has been added");

                } else {
                    System.out.println("The club " + playerToBeAdded.getClub() + " already has 7 players, no more players can be added");

                }
            }

            horizontalLine();

            return true;

        } else if (MenuOption == 4) {
            PlayerFile.writeToFile(PlayerDB);
            return false;

        } else {
            chooseCorrectOption();
            horizontalLine();
            return true;
        }
    }
}

