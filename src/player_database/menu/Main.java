package player_database.menu;

import java.util.List;
import java.util.Scanner;

//import player_database.database.PlayerDatabase;
import player_database.database.FileIO;
import player_database.database.Player;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);


        FileIO playerFile = new FileIO();
        List<Player> PlayerDB = playerFile.readFromFile();
        MainMenu menu = new MainMenu(PlayerDB, playerFile);

        //Main menu
        while (true) {
            //Writing the menu
            menu.MenuWrite();

            int MenuOption = input.nextInt();

            //Process the menu
            if (!menu.MenuProcess(MenuOption)) {
                break;
            }
        }
    }
}
