package client;

import database.ClubSearch;
import database.Player;
import database.PlayerSearch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.util.List;

public class Main extends Application {
    static Stage loginPageWindow;
    Scene sceneForLoginPageWindow;
    Parent root;

    static List<Player> playerDB;
    static List<Player> marketDB;
    static List<Player> sellablePlayerDB;
    static NetworkUtil networkUtil;
    static Client client;
    static ReadThreadClient readThreadClient;

    public static NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public static Client getClient() {
        return client;
    }

    public static ReadThreadClient getReadThreadClient() {
        return readThreadClient;
    }

    public static List<Player> getMarketDB() {
        return marketDB;
    }

    public static void setMarketDB(List<Player> marketDB) {
        Main.marketDB = marketDB;
    }

    public static void setPlayerDB(List<Player> playerDB) {
        Main.playerDB = playerDB;
    }

    public static List<Player> getPlayerDB() {
        return playerDB;
    }

    public static List<Player> getSellablePlayerDB() {
        return sellablePlayerDB;
    }

    public static void setSellablePlayerDB(List<Player> sellablePlayerDB) {
        Main.sellablePlayerDB = sellablePlayerDB;
    }

    public static Stage getLoginPageWindow() {
        return loginPageWindow;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    //create connection and show login page
        String serverAddress = "127.0.0.1";
        int serverPort = 44444;
        client = new Client(serverAddress, serverPort);
        networkUtil = client.getNetworkUtil();
        readThreadClient = client.getReadThreadClient();


        loginPageWindow = primaryStage;
        loginPageWindow.setTitle("Football Manager Login");

        sceneForLoginPageWindow = new Scene(FXMLLoader.load(getClass().getResource("/views/loginPage.fxml")));
        loginPageWindow.setScene(sceneForLoginPageWindow);
//        initialize();
        loginPageWindow.show();
    }

    public void initialize() {
//        try {
//            playerDB = FileIO.getInstance().readFromFile();
//        } catch (Exception e) {
//            System.out.println("Error in reading players.txt: ");
//            e.printStackTrace();
//        }
//        PlayerSearch.makeInstance(playerDB);
//        ClubSearch.makeInstance(playerDB);
    }
}
