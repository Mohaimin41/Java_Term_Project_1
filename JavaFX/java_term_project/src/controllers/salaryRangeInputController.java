package controllers;

import client.Main;
import database.Player;
import database.PlayerSearch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class salaryRangeInputController extends controller {
    @FXML
    TextField minSalary;
    @FXML
    Button searchBySalaryRangeButton;
    @FXML
    Button resetFieldButton;
    @FXML
    Button BackToPlayerSearchButton;
    @FXML
    TextField maxSalary;
    List<Player> searchResultPlayers;
    private Main main;

    @FXML
    void resetFields(ActionEvent actionEvent) {
        maxSalary.clear();
        minSalary.clear();
    }

    @FXML
    void backToPlayerSearch(ActionEvent actionEvent) {
        loadNewPage("playerSearchPage", actionEvent);
    }

    @FXML
    void searchBySalaryRange(ActionEvent event) {
        searchResultPlayers = PlayerSearch.getInstance().searchBySalaryRange(Double.parseDouble(minSalary.getText()),
                Double.parseDouble(maxSalary.getText()));
        if (searchResultPlayers.size() == 0) {
            AlertBox.display("No Such Players",
                    "There was no player found in the database matching the query");
        } else {
            playerTableController.init(searchResultPlayers);
            loadNewPage("playerTable", event);
        }
    }
}
