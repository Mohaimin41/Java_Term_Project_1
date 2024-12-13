package server;

import database.Player;

import java.util.ArrayList;
import java.util.List;

public class MarketList {
    static List<Player> marketPlayerList = new ArrayList<>();

    public static void init() {
        marketPlayerList = new ArrayList<>();
    }

    public static void addPlayerToMarketList(Player player) {
        marketPlayerList.add(player);
    }

    public static List<Player> getMarketPlayerList() {
        return marketPlayerList;
    }

    public static void setMarketPlayerList(List<Player> marketPlayerList) {
        MarketList.marketPlayerList = marketPlayerList;
    }

    public static boolean isPlayerInMarketList(Player player) {
        return marketPlayerList.contains(player);
    }
}
