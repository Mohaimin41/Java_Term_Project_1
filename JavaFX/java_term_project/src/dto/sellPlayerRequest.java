package dto;

import database.Player;

import java.io.Serializable;

public class sellPlayerRequest implements Serializable {
    Player playerToBeSold;
    String clubSelling;

    public sellPlayerRequest() {
    }

    public Player getPlayerToBeSold() {
        return playerToBeSold;
    }

    public void setPlayerToBeSold(Player playerToBeSold) {
        this.playerToBeSold = playerToBeSold;
    }

    public String getClubSelling() {
        return clubSelling;
    }

    public void setClubSelling(String clubSelling) {
        this.clubSelling = clubSelling;
    }

    @Override
    public String toString() {
        return "sellPlayerRequest{" +
                "playerToBeSold=" + playerToBeSold +
                ", clubSelling='" + clubSelling + '\'' +
                '}';
    }
}
