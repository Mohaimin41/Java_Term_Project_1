package controllers;

import client.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Arrays;

public class marketPageController extends controller{
    @FXML Button allPlayerPageButton;
    @FXML
    Button buyPlayerButton;
    @FXML Button sellPlayerButton;
    @FXML Button backToMainButton;

    @FXML void handleBuyPlayerButton(ActionEvent event) {
        buyPlayerPageController.init(Main.getMarketDB());
        loadNewPage("buyPlayerPage", event);
    }

    @FXML void handleSellPlayerButton(ActionEvent event) {
        sellPlayerPageController.init(Main.getSellablePlayerDB());
        loadNewPage("sellPlayerPage", event);
    }

    @FXML void handleBackToMainButton(ActionEvent event) {
        loadNewPage("mainPage", event);
    }

    @FXML void handleAllPlayerPageButton(ActionEvent event) {
        playerTableController.init(Main.getPlayerDB());
        loadNewPage("playerTable", event);
    }
}
