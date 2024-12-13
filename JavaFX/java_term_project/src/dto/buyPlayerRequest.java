package dto;

import database.Player;

import java.io.Serializable;

public class buyPlayerRequest implements Serializable {
    Player playerToBeBought;
    String clubBuying;

    public buyPlayerRequest() {
    }

    public String getClubBuying() {
        return clubBuying;
    }

    public void setClubBuying(String clubBuying) {
        this.clubBuying = clubBuying;
    }

    public Player getPlayerToBeBought() {
        return playerToBeBought;
    }

    public void setPlayerToBeBought(Player playerToBeBought) {
        this.playerToBeBought = playerToBeBought;
    }
}
