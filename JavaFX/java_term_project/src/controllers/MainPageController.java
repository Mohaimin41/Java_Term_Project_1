package controllers;

import client.Client;
import client.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainPageController extends controller {
    @FXML Label clubNameLabel;
    @FXML Button playerMarketButton;
    @FXML
    Button playerSearchButton;
    @FXML
    Button clubSearchButton;
    @FXML
    Button exitButton;
    @FXML
    Button addPlayerButton;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void initialize() {
        clubNameLabel.setText(Client.getClubName());
        clubNameLabel.setAlignment(Pos.BASELINE_CENTER);
    }

    @FXML
    void searchPlayer(ActionEvent actionEvent) {
        loadNewPage("playerSearchPage", actionEvent);
    }

    @FXML
    void searchClubs(ActionEvent actionEvent) {
        loadNewPage("clubSearchPage", actionEvent);
    }

    @FXML
    void exit(ActionEvent actionEvent) {
        try {
            //FileIO.getInstance().writeToFile(Main.getPlayerDB());
//            Main.getLoginPageWindow().close();
            Stage mainPageWindow = (Stage) exitButton.getScene().getWindow();
            mainPageWindow.close();

            Main.getLoginPageWindow().show();
        } catch (Exception e) {
            System.out.println("MainPageController theke loginPage e jete error @line 48");
            e.printStackTrace();
        }

    }

    @FXML void handlePlayerMarketButton(ActionEvent event) {
        loadNewPage("marketPage", event);
    }
}

