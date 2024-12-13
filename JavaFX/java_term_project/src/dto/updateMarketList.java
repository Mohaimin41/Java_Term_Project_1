package dto;

import database.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class updateMarketList implements Serializable {
    List<Player> updatedMarketedPlayerList = new ArrayList<>();
    String message;

    public updateMarketList(List<Player> updatedMarketedPlayerList) {
        this.updatedMarketedPlayerList = updatedMarketedPlayerList;
    }

    public updateMarketList() {}

    public List<Player> getUpdatedMarketedPlayerList() {
        return updatedMarketedPlayerList;
    }

    public void setUpdatedMarketedPlayerList(List<Player> updatedMarketedPlayerList) {
        this.updatedMarketedPlayerList = updatedMarketedPlayerList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "updateMarketList{" +
                "updatedMarketedPlayerList=" + updatedMarketedPlayerList +
                ", message='" + message + '\'' +
                '}';
    }
}
