package server;

import database.Player;
import dto.*;
import util.NetworkUtil;

import java.io.IOException;
import java.util.Arrays;

public class requestHandlers {

    loginResponse loginHandler(loginRequest request, NetworkUtil networkUtil) {
        clubInfo clubToBeLoggedIn = Server.clientMap.get(request.getClubName());

        if (clubToBeLoggedIn != null) {
            if (clubToBeLoggedIn.getPassword().equals(request.getPassword())) {
                clubToBeLoggedIn.setNetworkUtil(networkUtil);
                clubToBeLoggedIn.setOnline(true);

                loginResponse response = new loginResponse(true);
                response.setClub(request.getClubName());
                response.setAllPlayerList(Server.playerDB, request.getClubName());
                response.setCurrentMarketedPlayerList(MarketList.getMarketPlayerList());

                return response;
            } else {
                return new loginResponse(false);
            }
        }
        return new loginResponse(false);
    }

    sellPlayerResponse sellPlayerRequestHandler(sellPlayerRequest request) {
        //add player to the market if not present already
        if (MarketList.getMarketPlayerList().isEmpty()) {
            MarketList.addPlayerToMarketList(request.getPlayerToBeSold());
        } else {
            if (!MarketList.isPlayerInMarketList(request.getPlayerToBeSold())) {
                MarketList.addPlayerToMarketList(request.getPlayerToBeSold());
            }
        }
        sellPlayerResponse response = new sellPlayerResponse();

        response.setPlayerToBeSold(request.getPlayerToBeSold());
        return response;
    }

    synchronized static buyPlayerResponse buyRequestHandler(buyPlayerRequest request) {

        if (MarketList.isPlayerInMarketList(request.getPlayerToBeBought())) {
            buyPlayerResponse response = new buyPlayerResponse(request.getPlayerToBeBought(), true);

            //change the players club name in central database;
            Server.playerDB.get(Server.playerDB.indexOf(request.getPlayerToBeBought())).setClub(request.getClubBuying());
            //remove player from market
            MarketList.getMarketPlayerList().remove(request.getPlayerToBeBought());

            response.getPlayerToBeBought().setClub(request.getClubBuying());
            return response;
        } else {
            return new buyPlayerResponse(request.getPlayerToBeBought(), false);
        }
    }

    void logoutRequestHandler(logoutRequest request) {
        clubInfo clubToBeLoggedOut = Server.clientMap.get(request.getClub());
//        try {
//            clubToBeLoggedOut.getNetworkUtil().closeConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //not doing anything for now
        System.out.println(request.getClub() + " logged out but connection is active probably");
    }
}
