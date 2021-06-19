package player_database.menu;

import java.util.List;
import java.util.Scanner;

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

    default int getIntFromUser() {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Please enter a number:");
            input.next();
        }

        return input.nextInt();
    }

    default double getDoubleFromUser() {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextDouble()) {
            System.out.println("Please enter a number:");
            input.next();
        }

        return input.nextDouble();
    }

    default String getValidPlayerPosition() {
        Scanner input = new Scanner(System.in);

        while (true) {
            String givenPosition = input.nextLine();
            if (!isValidPosition(givenPosition.trim())) {
                System.out.println("Please enter a valid player position:");
            } else {
                return givenPosition.trim();
            }
        }
    }

    private boolean isValidPosition(String givenPosition) {
        String [] positions = {"goalkeeper", "defender", "midfielder", "forward"};

        for (String position : positions) {
            if (givenPosition.toLowerCase().equalsIgnoreCase(position)) {
                return true;
            }
        }
        return false;
    }

}