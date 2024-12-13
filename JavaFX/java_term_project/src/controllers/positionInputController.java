package controllers;

import client.Main;
import database.Player;
import database.PlayerSearch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.Arrays;
import java.util.List;

public class positionInputController extends controller {
    @FXML
    ComboBox<String> playerPositionSelector;
    @FXML
    Button searchByPositionButton;
    @FXML
    Button resetFieldButton;
    @FXML
    Button BackToPlayerSearchButton;
    List<Player> searchResultPlayers;
    private Main main;

    @FXML
    public void initialize() {
        //playerPositionSelector = new ComboBox<>();
//        System.out.println("in position initialize...");
        playerPositionSelector.getItems().addAll("Goalkeeper", "Defender", "Midfielder", "Forward");
//        System.out.println(Arrays.toString(playerPositionSelector.getItems().toArray()));
//
    }

    @FXML
    void searchByPosition(ActionEvent actionEvent) {
        searchResultPlayers = PlayerSearch.getInstance().searchByPosition(playerPositionSelector.getValue());
        playerTableController.init(searchResultPlayers);
        loadNewPage("playerTable", actionEvent);
    }

    @FXML
    void resetFields(ActionEvent actionEvent) {
        playerPositionSelector.getSelectionModel().clearSelection();
        playerPositionSelector.setValue(null);
    }

    @FXML
    void backToPlayerSearch(ActionEvent actionEvent) {
        loadNewPage("playerSearchPage", actionEvent);
    }
}
