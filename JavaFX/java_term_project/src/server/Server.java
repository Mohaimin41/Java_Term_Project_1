package server;

import database.FileIO;
import database.Player;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class Server {

    static HashMap<String, clubInfo> clientMap;
    static List<Player> playerDB;
    private ServerSocket serverSocket;

    Server() {
        initialize();

        try {
            serverSocket = new ServerSocket(44444);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("server.Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(clientMap, networkUtil);
    }

    public static void main(String[] args) {
        Server server = new Server();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                FileIO.getInstance().writeToFile(playerDB);
                System.out.println("trying to save the file before closing @Server line 44");

            } catch (Exception e) {
                System.out.println("problem in saving the file in Server closing @line 44");
                e.printStackTrace();
            }
        }));
    }

    public static void initialize() {
        try {
            playerDB = FileIO.getInstance().readFromFile();
        } catch (Exception e) {
            System.out.println("Error in reading players.txt: ");
            e.printStackTrace();
        }

//        MarketList.init();

        //manually add clubs to clientMap for now
        clientMap = new HashMap<>();
        clubInfo Liverpool = new clubInfo("liverpool", false);
        clubInfo ManchesterCity = new clubInfo("manchesterCity", false);
        clubInfo ManchesterUnited = new clubInfo("manchesterUnited", false);
        clubInfo Chelsea = new clubInfo("chelsea", false);
        clubInfo Arsenal = new clubInfo("arsenal", false);

        clientMap.put("Arsenal", Arsenal);
        clientMap.put("Chelsea", Chelsea);
        clientMap.put("Manchester United", ManchesterUnited);
        clientMap.put("Manchester City", ManchesterCity);
        clientMap.put("Liverpool", Liverpool);
    }
}
