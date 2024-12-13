package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {
    Stage window;
    Scene sceneForWindow;
    Parent root;

    public controller() {

    }

    public void loadNewPage(String viewsFileName, ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/views/" + viewsFileName + ".fxml"));
        } catch (IOException e) {
            System.out.println("Error in controllers.controller.loadNewPage er root set up: " );
            e.printStackTrace();
        }
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sceneForWindow = new Scene(root);
        window.setTitle(viewsFileName);
        window.setScene(sceneForWindow);
        window.show();
    }
}
