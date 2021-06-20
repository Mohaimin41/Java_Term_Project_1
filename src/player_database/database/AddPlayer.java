package player_database.database;

import java.util.List;
import java.util.Scanner;

import player_database.menu.InputOutputFormatter;

public class AddPlayer implements InputOutputFormatter {
    List<Player> PlayerDB;

    public AddPlayer(List<Player> PlayerDB) {
        this.PlayerDB = PlayerDB;
    }

    public int clubTotalPlayer(String club) {
        int totalPlayerInClub = 0;

        for (Player player : PlayerDB) {
            if (player.getClub().equalsIgnoreCase(club)) {
                totalPlayerInClub++;
            }
        }

        return totalPlayerInClub;
    }

    public boolean isNamePresent(Player playerToBeAdded) {
        for (Player player : PlayerDB) {
            if (player.getName().equalsIgnoreCase(playerToBeAdded.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasClubSpace(Player playerToBeAdded) {
        return clubTotalPlayer(playerToBeAdded.getClub()) < 7;
    }

    public boolean isNumberPresentInClub(Player playerToBeAdded) {
        for (Player player : PlayerDB) {
            if ((playerToBeAdded.getClub().trim().equalsIgnoreCase(player.getClub().trim()))
                    && (playerToBeAdded.getNumber() == player.getNumber())) {
                return true;
            }
        }

        return false;
    }

    public void addPlayer(Player playerToBeAdded) {
        PlayerDB.add(playerToBeAdded);
    }

    public Player inputPlayer() {
        Scanner input = new Scanner(System.in);
        Player playerToBeAdded = new Player();

        System.out.println("Player Name:");
        playerToBeAdded.setName(input.nextLine().trim());

        System.out.println("Player Country:");
        playerToBeAdded.setCountry(input.nextLine().trim());

        System.out.println("Player Club:");
        playerToBeAdded.setClub(input.nextLine().trim());

        System.out.println("Player Position: (Goalkeeper, Defender, Midfielder, Forward)");
        playerToBeAdded.setPosition(getValidPlayerPosition());

        System.out.println("Player Age:");
        playerToBeAdded.setAge(getIntFromUser());

        System.out.println("Player Height:");
        playerToBeAdded.setHeight(getDoubleFromUser());

        System.out.println("Player Number:");
        playerToBeAdded.setNumber(getIntFromUser());

        System.out.println("Player's Weekly Salary:");
        playerToBeAdded.setWeeklySalary(getDoubleFromUser());

        return playerToBeAdded;
    }
}
