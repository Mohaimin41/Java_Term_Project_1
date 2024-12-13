package dto;

import database.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class loginResponse implements Serializable {
    List<Player> allPlayerList;
    List<Player> currentMarketedPlayerList;

    String club;

    boolean isLoginSuccessful;

    public loginResponse(boolean isLoginSuccessful) {
        allPlayerList = new ArrayList<>();
        currentMarketedPlayerList = new ArrayList<>();
        this.isLoginSuccessful = isLoginSuccessful;
    }

    public boolean isLoginSuccessful() {
        return isLoginSuccessful;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        isLoginSuccessful = loginSuccessful;
    }

    public List<Player> getAllPlayerList() {
        return allPlayerList;
    }

    public void setAllPlayerList(List<Player> AllPlayerList, String Club) {
        for (Player player: AllPlayerList
        ) {
            if (player.getClub().equals(Club)) {
                allPlayerList.add(player);
            }
        }
        this.club = Club;
    }

    public List<Player> getCurrentMarketedPlayerList() {
        return currentMarketedPlayerList;
    }

    public void setCurrentMarketedPlayerList(List<Player> currentMarketedPlayerList) {
        this.currentMarketedPlayerList = currentMarketedPlayerList;
    }

}
