package controllers;

import client.Client;
import client.Main;
import database.ClubSearch;
import database.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;
//import java.util.ResourceBundle;

public class ClubSearchPageController extends controller {
    @FXML
    TextField clubToBeFullSearched;
    @FXML
    Button maxSalaryInClubButton;
    @FXML
    Button maxAgeInClubButton;
    @FXML
    Button maxHeightInClubButton;
    @FXML
    Button totalYearlySalaryButton;
    @FXML
    Button backToMainButton;
    List<Player> searchResultPlayers;
    private Main main;

    @FXML
    void searchByMaxSalary(ActionEvent actionEvent) {
        if (ClubSearch.getInstance().searchClubByName(Client.getClubName())) {
            searchResultPlayers = ClubSearch.getInstance().printPlayerInClubBySalary(
                    ClubSearch.getInstance().maxSalaryInCLub(Client.getClubName()), Client.getClubName());
            playerTableController.init(searchResultPlayers);
            loadNewPage("playerTable", actionEvent);
        } else {
            alertForNoClub();
        }
    }

    @FXML
    void searchByMaxAge(ActionEvent actionEvent) {
        if (ClubSearch.getInstance().searchClubByName(Client.getClubName())) {
            searchResultPlayers = ClubSearch.getInstance().printPlayerInClubByAge(
                    ClubSearch.getInstance().maxAgeInCLub(Client.getClubName()), Client.getClubName());
            playerTableController.init(searchResultPlayers);
            loadNewPage("playerTable", actionEvent);
        } else {
            alertForNoClub();
        }
    }

    @FXML
    void searchByMaxHeight(ActionEvent actionEvent) {
        if (ClubSearch.getInstance().searchClubByName(Client.getClubName())) {
            searchResultPlayers = ClubSearch.getInstance().printPlayerInClubByHeight(
                    ClubSearch.getInstance().maxHeightInCLub(Client.getClubName()), Client.getClubName());
            playerTableController.init(searchResultPlayers);
            loadNewPage("playerTable", actionEvent);
        } else {
            alertForNoClub();
        }
    }

    @FXML
    void findTotalYearlySalary(ActionEvent actionEvent) {
        if (ClubSearch.getInstance().searchClubByName(Client.getClubName())) {
            String salary = String.format("%.2f", ClubSearch.getInstance().totalYearlySalaryClub(Client.getClubName()) );
            AlertBox.display("Total Yearly Salary", "The total yearly salary at "
                    + Client.getClubName().trim() + " is: " + salary + " euro.");
        } else {
            alertForNoClub();
        }
    }

    @FXML
    void handleBackToMain(ActionEvent actionEvent) {
        loadNewPage("mainPage", actionEvent);
    }

    private void alertForNoClub() {
        AlertBox.display("No Such Club", "There is no club named '" + Client.getClubName() + "' in the database." +
                "\nPlease try again.");
    }
}
