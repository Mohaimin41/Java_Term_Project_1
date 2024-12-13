package client;

import util.NetworkUtil;

import java.io.IOException;


public class WriteThreadClient {

    public static NetworkUtil networkUtil;
    //writing in the static networkutil in a new thread in each call, may not work
    public static void write(Object o){
        new Thread(() -> {
            try {
                networkUtil.write(o);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
//        try {
//            networkUtil.write(o);
////            System.out.println("Writing object in write thread in Write Thread @ line 22" + o );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void setNetworkUtil(NetworkUtil networkUtil) {
        WriteThreadClient.networkUtil = networkUtil;
    }
}
