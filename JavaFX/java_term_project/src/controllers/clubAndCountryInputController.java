package controllers;

import client.Main;
import database.Player;
import database.PlayerSearch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;
//import java.util.ResourceBundle;

public class clubAndCountryInputController extends controller {
    @FXML Button searchByCountryButton;
    @FXML
    TextField countryBeSearched;
    @FXML
    Button searchByNameButton;
    @FXML
    Button resetFieldButton;
    @FXML
    Button BackToPlayerSearchButton;
    @FXML
    TextField clubToBeSearched;
    List<Player> searchResultList;
    private Main main;

    @FXML
    void searchByClubCountry(ActionEvent actionEvent) {
        if (clubToBeSearched.getText().trim().equals("ANY")) {
            searchResultList = PlayerSearch.getInstance().searchByCountry(countryBeSearched.getText().trim());
        } else {
            searchResultList = PlayerSearch.getInstance().searchByClubCountry(countryBeSearched.getText().trim(),
                    clubToBeSearched.getText().trim());
        }
        if (searchResultList.size() == 0) {
            AlertBox.display("No Such Players",
                    "There was no player found in the database matching the query");
        } else {
            playerTableController.init(searchResultList);
            loadNewPage("playerTable", actionEvent);
        }
    }

    @FXML
    void resetFields(ActionEvent actionEvent) {
//        clubToBeSearched.clear();
        countryBeSearched.clear();
    }

    @FXML
    void backToPlayerSearch(ActionEvent actionEvent) {
        loadNewPage("playerSearchPage", actionEvent);
    }

    @FXML void searchByCountry(ActionEvent event) {
        searchResultList = PlayerSearch.getInstance().searchByCountry(countryBeSearched.getText().trim());

        if (searchResultList.size() == 0) {
            AlertBox.display("No Such Players",
                    "There was no player found in the database matching the query");
        } else {
            playerTableController.init(searchResultList);
            loadNewPage("playerTable", event);
        }
    }
}
