package dto;

import database.Player;

import java.io.Serializable;

public class sellPlayerResponse implements Serializable {
    Player playerToBeSold;
//    final String response = "The player '" + playerToBeSold.getName() + "' has been added to the market.";

    public sellPlayerResponse() {
    }

    public Player getPlayerToBeSold() {
        return playerToBeSold;
    }

    public void setPlayerToBeSold(Player playerToBeSold) {
        this.playerToBeSold = playerToBeSold;
    }

    @Override
    public String toString() {
        return "sellPlayerResponse{" +
                "playerToBeSold=" + playerToBeSold +
                '}';
    }
}
