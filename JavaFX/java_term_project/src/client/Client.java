package client;

import util.NetworkUtil;

public class Client {
    private NetworkUtil networkUtil;
    private ReadThreadClient readThreadClient;
    private static String clubName;

    public static void setClubName(String ClubName) {
        clubName = ClubName;
    }

    public static String getClubName() {
        return clubName;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public ReadThreadClient getReadThreadClient() {
        return readThreadClient;
    }

    public Client(String serverAddress, int serverPort) {
        try {
            networkUtil = new NetworkUtil(serverAddress, serverPort);
            //Setting the static networkUtil of the writeThreadClient. So that we can call it from anywhere later.
            WriteThreadClient.setNetworkUtil(networkUtil);
            //Making a new readThreadClient
            readThreadClient = new ReadThreadClient(networkUtil);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}


