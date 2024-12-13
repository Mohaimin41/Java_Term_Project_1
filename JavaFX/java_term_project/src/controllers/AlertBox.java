package controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String alertBoxTitle, String alertBoxMessage) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(alertBoxTitle);
        window.setMinWidth(400);
        window.setWidth(700);



        Label label1 = new Label(alertBoxMessage);


        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layoutForAlertWindow = new VBox(40);
        layoutForAlertWindow.getChildren().addAll(label1, closeButton);
        layoutForAlertWindow.setAlignment(Pos.CENTER);

        Scene sceneForAlertWindow = new Scene(layoutForAlertWindow);

//        sceneForAlertWindow.getStylesheets().add("/values/styles.css");
        sceneForAlertWindow.getStylesheets().add(AlertBox.class.getResource("/values/styles.css").toExternalForm());
        layoutForAlertWindow.getStyleClass().addAll("mainPage");
        closeButton.getStyleClass().add("commonButton");
        label1.getStyleClass().add("commonFontForTexts");

        window.setScene(sceneForAlertWindow);
        window.showAndWait();

    }
}
