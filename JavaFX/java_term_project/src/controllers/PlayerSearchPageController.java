package controllers;

import client.Main;
import database.PlayerSearch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PlayerSearchPageController extends controller {
    @FXML Button searchByCountryButton;
    @FXML
    Button searchByPlayerNameButton;
    @FXML
    Button searchByClubAndCountryButton;
    @FXML
    Button searchByPositionButton;
    @FXML
    Button searchBySalaryRangeButton;
    @FXML
    Button countrywisePlayerCountButton;
    @FXML
    Button backToMainButton;
    private Main main;

    @FXML
    void searchByPlayerNameInput(ActionEvent actionEvent) {
        loadNewPage("playerNameInput", actionEvent);
    }

    @FXML
    void searchByClubCountryNameInput(ActionEvent actionEvent) {
        loadNewPage("clubAndCountryInput", actionEvent);
    }

    @FXML
    void searchByPositionInput(ActionEvent actionEvent) {
//        positionInputController.init();
        loadNewPage("positionInput", actionEvent);
    }

    @FXML
    void searchBySalaryRangeButton(ActionEvent event) {
        loadNewPage("salaryRangeInput", event);
    }

    @FXML
    void countrywisePlayerCount(ActionEvent actionEvent) {
        countryWisePlayerCountController.init(PlayerSearch.getInstance().countryStat());
        loadNewPage("countryWisePlayerCount", actionEvent);
    }

    @FXML
    void backToMain(ActionEvent actionEvent) {
        loadNewPage("mainPage", actionEvent);
    }

    @FXML void searchByCountryNameInput(ActionEvent event) {
        loadNewPage("clubAndCountryInput", event);
    }
}
