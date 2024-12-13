package client;

import controllers.*;
import database.ClubSearch;
import database.Player;
import database.PlayerSearch;
import dto.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class responseHandler {
    void loginResponseHandler(loginResponse response) {
        if (response.isLoginSuccessful()) {

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Client.setClubName(response.getClub());

                    Main.setPlayerDB(response.getAllPlayerList());
                    Main.setMarketDB(response.getCurrentMarketedPlayerList());
                    Main.setSellablePlayerDB(response.getAllPlayerList());

                    PlayerSearch.makeInstance(Main.getPlayerDB());
                    ClubSearch.makeInstance(Main.getPlayerDB());

//                   This is to not use loadNewPage method, as it takes a not null action event, can't get that now
                    Stage homePageWindow = new Stage();
                    try {
                        homePageWindow.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/mainPage.fxml"))));
                    } catch (IOException e) {
                        System.out.println("error in loading main page in responseHandler @line 37:");
                        e.printStackTrace();
                    }
                    Main.getLoginPageWindow().close();
                    homePageWindow.setTitle("Football Player Manager");
                    homePageWindow.show();
                }
            });

        } else {
            Platform.runLater(() ->
                    AlertBox.display("Failed Login!", "The login attempt failed." +
                    "\nPlease try again with correct club name and password"));
        }
    }

    void updateMarketListHandler(updateMarketList response) {
        //attempt to refresh the market list table at buy player page controller, may not work
        Platform.runLater(() -> {
            Main.setMarketDB(response.getUpdatedMarketedPlayerList());
//                buyPlayerPageController BuyingPageController = new buyPlayerPageController();
//                BuyingPageController.getPlayerToBeBoughtTable().refresh();
            buyPlayerPageController.init(Main.getMarketDB());
        });

    }

    void updatePlayerListHandler(updatePlayerList response) {
         //attempt to refresh the player list table at player page controller, may not work
        Platform.runLater(() -> {
            Main.setPlayerDB(response.getUpdatedPlayerDB());
//                playerTableController PlayerTableController = new playerTableController();
//                PlayerTableController.getPlayerTable().refresh();
            playerTableController.init(Main.getPlayerDB());

            PlayerSearch.getInstance().setPlayerDB(Main.getPlayerDB());
            ClubSearch.getInstance().setPlayerDB(Main.getPlayerDB());

        });
    }

    void sellPlayerResponseHandler(sellPlayerResponse response) {
        //attempt to refresh the sellable player list table at sell player page controller, may not work
        Platform.runLater(() -> {
            Main.getSellablePlayerDB().remove(response.getPlayerToBeSold());
//                sellPlayerPageController SellPlayerPageController = new sellPlayerPageController();
//
//                SellPlayerPageController.getPlayerToBeSoldTable().refresh();

            sellPlayerPageController.init(Main.getSellablePlayerDB());
        });
}

    void buyPlayerResponseHandler(buyPlayerResponse response) {
        Platform.runLater(() -> {
            if (response.isBuySuccessful()) {
                Main.getSellablePlayerDB().add(response.getPlayerToBeBought());
                AlertBox.display("Success!",
                        "You have successfully bought the player '" + response.getPlayerToBeBought().getName() + "'.");
            } else {
                AlertBox.display("Failure!",
                        "Sorry, the player '" + response.getPlayerToBeBought().getName() + "' has already been bought by another club.");
            }
        });
    }
}
