import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        MainMenu menu = new MainMenu();
        FileIO playerFile = new FileIO();
        List<Player> PlayerDB = playerFile.readFromFile();

        //Main menu
        while (true) {
            //Writing the menu
            menu.MenuWrite();

            int MenuOption = input.nextInt();

            //Process the menu
            if(!menu.MenuProcess(MenuOption, PlayerDB, playerFile)) {
                break;
            }
        }
    }
}
