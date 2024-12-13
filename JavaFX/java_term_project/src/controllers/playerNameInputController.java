package controllers;

import client.Main;
import database.Player;
import database.PlayerSearch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class playerNameInputController extends controller {
    @FXML
    TextField playerToBeSearched;
    @FXML
    Button searchByNameButton;
    @FXML
    Button resetFieldButton;
    @FXML
    Button BackToPlayerSearchButton;
    Player searchResultPlayer;
    private Main main;

    @FXML
    void searchByPlayerName(ActionEvent actionEvent) {
        if (PlayerSearch.getInstance().searchByName(playerToBeSearched.getText())) {
            searchResultPlayer = PlayerSearch.getInstance().returnSearchedPlayer(playerToBeSearched.getText());

//            singlePlayerShowController resultPage = new singlePlayerShowController();
//            System.out.println("Created controller");
            singlePlayerShowController.init(searchResultPlayer);
//            System.out.println("initialized, allegedly");
            loadNewPage("singlePlayerShow", actionEvent);
        } else {
            noSuchPlayerAlert();
        }
    }

    @FXML
    void resetFields(ActionEvent actionEvent) {
        playerToBeSearched.clear();
    }

    @FXML
    void backToPlayerSearch(ActionEvent actionEvent) {
        loadNewPage("playerSearchPage", actionEvent);
    }

    void noSuchPlayerAlert() {
        AlertBox.display("No Such Player", "There is no player named '" + playerToBeSearched.getText() + "' in the database." +
                "\nPlease Try again.");
    }

}
