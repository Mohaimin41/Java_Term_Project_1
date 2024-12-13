package controllers;

import database.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class singlePlayerShowController extends controller {
    @FXML Button backToMainButton;
    @FXML Button backToPlayerSearchButton;
    @FXML
    Label playerNameLabel;
    @FXML
    Label playerAgeLabel;
    @FXML
    Label playerPositionLabel;
    @FXML
    Label playerHeightLabel;
    @FXML
    Label playerWeeklySalaryLabel;
    @FXML
    Label playerClubLabel;
    @FXML
    Label playerCountryLabel;
    @FXML
    Label playerNumberLabel;

    static Player playerToBeShowed;

//    public singlePlayerShowController() {
//    }

    //    @FXML
    static void init(Player PlayerToBeShowed) {
        playerToBeShowed = PlayerToBeShowed;
    }

    @FXML
    public void initialize() {
        playerNameLabel.setText(playerToBeShowed.getName());

        playerCountryLabel.setText("From " + playerToBeShowed.getCountry());

        playerClubLabel.setText("Club: " + playerToBeShowed.getClub());

        playerPositionLabel.setText(playerToBeShowed.getPosition() + ",");

        playerAgeLabel.setText(playerToBeShowed.getAge() + " years old, ");

        playerHeightLabel.setText(playerToBeShowed.getHeight() + " meter");

        playerNumberLabel.setText("Number " + playerToBeShowed.getNumber());

        playerWeeklySalaryLabel.setText("Weekly Salary " + playerToBeShowed.getWeeklySalary() + " euro");
    }

    @FXML
    void handleBackToPlayerSearchButton(ActionEvent event) {
        loadNewPage("playerSearchPage", event);
    }

    @FXML
    void handleBackToMainButton(ActionEvent event) {
        loadNewPage("mainPage", event);
    }
}
