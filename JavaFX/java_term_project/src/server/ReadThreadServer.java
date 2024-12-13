package server;

import client.Client;
import database.Player;
import dto.*;
import util.NetworkUtil;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer extends requestHandlers implements Runnable {
    public HashMap<String, clubInfo> clientMap;
    private final Thread thr;
    private final NetworkUtil networkUtil;


    public ReadThreadServer(HashMap<String, clubInfo> map, NetworkUtil networkUtil) {
        this.clientMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {

            while (true) {

                Object o = networkUtil.read();

                if (o instanceof loginRequest) {
                    networkUtil.write(loginHandler((loginRequest) o, networkUtil));
                }

                if (o instanceof sellPlayerRequest) {
                    networkUtil.write(sellPlayerRequestHandler((sellPlayerRequest) o));

                    //create and broadcast the updated market list to all clients
                    updateMarketList newMarketList = new updateMarketList();
                    newMarketList.setUpdatedMarketedPlayerList(MarketList.getMarketPlayerList());
                    newMarketList.setMessage("bechar jonno list gelo, bechse: " + ((sellPlayerRequest) o).getClubSelling());

//                    sendNewMarketUpdateListToAll(newMarketList);

                    //try and send a playerList directly
                    List<Player> updatedMarketedPlayerList = newMarketList.getUpdatedMarketedPlayerList();
                    sendNewMarketUpdateListToAll(updatedMarketedPlayerList);

                }

                if (o instanceof buyPlayerRequest) {
                    networkUtil.write(requestHandlers.buyRequestHandler((buyPlayerRequest) o));

                    //create and broadcast the updated market list to all clients
                    updateMarketList newMarketList = new updateMarketList();
                    newMarketList.setUpdatedMarketedPlayerList(MarketList.getMarketPlayerList());
                    newMarketList.setMessage("kenar jonno list gelo, kinse " + ((buyPlayerRequest) o).getClubBuying());

//                    sendNewMarketUpdateListToAll(newMarketList);
                    //try and send a playerList directly
                    List<Player> updatedMarketedPlayerList = newMarketList.getUpdatedMarketedPlayerList();
                    sendNewMarketUpdateListToAll(updatedMarketedPlayerList);


                    //create and send the updated playerList to the buyer
                    updatePlayerList newPlayerList = new updatePlayerList(Server.playerDB, ((buyPlayerRequest) o).getClubBuying());

                    networkUtil.write(newPlayerList);

                    //send the updated playerList to the seller if he is still online
                    updatePlayerList newPlayerListForSeller = new updatePlayerList(Server.playerDB, ((buyPlayerRequest) o).getPlayerToBeBought().getClub());
                    if (clientMap.get(((buyPlayerRequest) o).getPlayerToBeBought().getClub() ).getNetworkUtil() != null) {
                        clientMap.get(((buyPlayerRequest) o).getPlayerToBeBought().getClub() ).getNetworkUtil().write(newPlayerListForSeller);
                    }
                }

                if (o instanceof logoutRequest) {
                    logoutRequestHandler((logoutRequest) o);
                }
            }

        } catch (Exception e) {
            System.out.println("error at ReadThreadServer er run:");
            e.printStackTrace();
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                System.out.println("error in closing networkutil at ReadThreadServer @line 74");
                e.printStackTrace();
            }
        }
    }

    void sendNewMarketUpdateListToAll(Object obj) {
        //broadcast updateMarketList to all clients

        for (String client : Server.clientMap.keySet()) {
            clubInfo club = Server.clientMap.get(client);
            if (club.getNetworkUtil() != null) {
                try {
                    club.getNetworkUtil().write(obj);
                    System.out.println("sending a market list to all in read thread @line 96 @thread " + Thread.currentThread().getName() + "@time: " + java.time.LocalTime.now());
                    System.out.println(obj);

                } catch (IOException e) {
                    System.out.println("error in sendObjectToAll in ReadThreadServer @line 88: ");
                    e.printStackTrace();
                }
            }
        }
    }
}



