package dto;

import database.Player;

import java.io.Serializable;

public class buyPlayerResponse implements Serializable {
    Player playerToBeBought;
//    final String failure = "Sorry, the player '" + playerToBeBought.getName() + "' has already been bought";
//    final String success = "Congratulations! \nYou have successfully bought the player '" + playerToBeBought.getName() + "'";
    boolean isBuySuccessful;

    public buyPlayerResponse(Player playerToBeBought, boolean isBuySuccessful) {
        this.playerToBeBought = playerToBeBought;
        this.isBuySuccessful = isBuySuccessful;
    }

    public buyPlayerResponse() {
    }

//    public String getFailure() {
//        return failure;
//    }
//
//    public String getSuccess() {
//        return success;
//    }

    public Player getPlayerToBeBought() {
        return playerToBeBought;
    }

    public void setPlayerToBeBought(Player playerToBeBought) {
        this.playerToBeBought = playerToBeBought;
    }

    public boolean isBuySuccessful() {
        return isBuySuccessful;
    }

    public void setBuySuccessful(boolean buySuccessful) {
        isBuySuccessful = buySuccessful;
    }

}
