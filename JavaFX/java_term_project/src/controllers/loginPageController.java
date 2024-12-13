package controllers;

import client.Main;
import client.WriteThreadClient;
import dto.loginRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginPageController {
    @FXML TextField clubName;
    @FXML
    PasswordField clubPassword;
    @FXML
    Button loginButton;
    @FXML Button resetButton;
    @FXML Button exitButton;

    @FXML void loginButtonHandler(ActionEvent event) {
        loginRequest newLoginRequest = new loginRequest();
        newLoginRequest.setClubName(clubName.getText().trim());
        newLoginRequest.setPassword(clubPassword.getText().trim());
        WriteThreadClient.write(newLoginRequest);
    }

    @FXML void resetButtonHandler(ActionEvent event) {
        clubName.clear();
        clubPassword.clear();
    }

    @FXML void exitButtonHandler(ActionEvent event) {
        try {
            Main.getLoginPageWindow().close();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error in closing the program, main.loginPage, call generated by loginPageController @line 37-38");
            e.printStackTrace();
        }
    }
}