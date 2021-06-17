package player_database.database;

import java.util.List;
import java.util.Scanner;

public class AddPlayer {
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

    public void addPlayer(Player playerToBeAdded) {
        PlayerDB.add(playerToBeAdded);
    }

    public Player inputPlayer() {
        Scanner input = new Scanner(System.in);
        Player playerToBeAdded = new Player();

        System.out.println("Player name:");
        playerToBeAdded.setName(input.nextLine());

        System.out.println("Country:");
        playerToBeAdded.setCountry(input.nextLine());

        System.out.println("Age:");
        playerToBeAdded.setAge(input.nextInt());

        System.out.println("Height:");
        playerToBeAdded.setHeight(input.nextDouble());

        System.out.println("Club:");
        input.nextLine();
        playerToBeAdded.setClub(input.nextLine());

        System.out.println("Position:");
        playerToBeAdded.setPosition(input.nextLine());

        System.out.println("Number:");
        playerToBeAdded.setNumber(input.nextInt());

        System.out.println("Weekly Salary:");
        playerToBeAdded.setWeeklySalary(input.nextDouble());

        return playerToBeAdded;
    }
}
