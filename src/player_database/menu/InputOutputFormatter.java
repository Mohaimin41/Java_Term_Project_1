package player_database.menu;

import java.util.List;

import player_database.database.Player;

public interface InputOutputFormatter {
    default void horizontalLine() {
        System.out.println("=========================================================================================");
    }

    default void chooseCorrectOption() {
        System.out.println("Please choose a correct option:");
        horizontalLine();
    }

    default void printNoPlayerFound() {
        System.out.println("There were no player(s) found with the given query, please try again");
        horizontalLine();
    }

    //prints all players in a given list as answer for a query
    default void printPlayerList(List<Player> searchedPlayerList) {

        if (searchedPlayerList.size() == 0) {
            printNoPlayerFound();
        } else {
            System.out.println(searchedPlayerList.size() + " player(s) were found with the given query:");

            int serial = 0;

            for (Player player : searchedPlayerList) {
                System.out.println(++serial + ".");
                player.display();
            }
        }
    }

    default void noSuchClubPrompt() {
        System.out.println("No such club with this name");
        horizontalLine();
    }
}