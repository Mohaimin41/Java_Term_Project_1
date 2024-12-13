package client;

import database.Player;
import dto.*;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadThreadClient extends responseHandler implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;

    public ReadThreadClient(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }


    public void run() {
        try {
            while (true) {

                Object o = networkUtil.read();

                if (o instanceof ArrayList<?>) {
                    Main.setMarketDB((List<Player>) o);
                }

                if (o instanceof loginResponse) {
                    loginResponseHandler((loginResponse) o);
                }

                if (o instanceof buyPlayerResponse) {
                    buyPlayerResponseHandler((buyPlayerResponse) o);
                }

                if (o instanceof sellPlayerResponse) {
                    sellPlayerResponseHandler((sellPlayerResponse) o);
                }

                if (o instanceof updatePlayerList) {
                    updatePlayerListHandler((updatePlayerList) o);
                }

                if (o instanceof updateMarketList) {
                    updateMarketListHandler((updateMarketList) o);
                    System.out.println("paisi market list @line 43 readThread @thread " + Thread.currentThread().getName()
                            + "@time: " + java.time.LocalTime.now() + "\n" + o.getClass().getName() + "ei je list: \n"
                            + o);
                }


            }

        } catch (Exception e) {
            System.out.println("readThread er run e error" + e);

        } finally {

            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



