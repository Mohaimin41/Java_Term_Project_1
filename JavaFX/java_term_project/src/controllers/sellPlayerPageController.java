package controllers;

import client.Client;
import client.Main;
import client.WriteThreadClient;
import database.Player;
import dto.sellPlayerRequest;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;
import java.util.List;

public class sellPlayerPageController extends controller {
    @FXML Button refreshButton;
    @FXML Label playerTableHeader;
    @FXML TableView<Player> playerToBeSoldTable;
    @FXML
    TableColumn<Player, String> Name;
    @FXML
    TableColumn<Player, Integer> Age;
    @FXML
    TableColumn<Player, String> Country;
    @FXML
    TableColumn<Player, String> Club;
    @FXML
    TableColumn<Player, String> Position;
    @FXML
    TableColumn<Player, Integer> Number;
    @FXML
    TableColumn<Player, Double> Height;
    @FXML
    TableColumn<Player, Double> WeeklySalary;

    @FXML Button putInMarketPlaceButton;
    @FXML Button resetButton;
    @FXML Button backToMarketButton;

    static ObservableList<Player> data = FXCollections.observableArrayList();
    //binding property
    private Property<ObservableList<Player>> sellPlayerListProperty = new SimpleObjectProperty<>(data);

    static sellPlayerPageController instance = null;

    public sellPlayerPageController() {}

    public static sellPlayerPageController getInstance() {
        if (instance == null) {
            instance = new sellPlayerPageController();
        }
        return instance;
    }

    public TableView<Player> getPlayerToBeSoldTable() {
        return playerToBeSoldTable;
    }

    public static void init(List<Player> playerData) {
        data.clear();
//        data.addAll(playerData);
        data.setAll(playerData);
    }

    @FXML
    public void initialize() {

        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));

        Country.setCellValueFactory(new PropertyValueFactory<>("Country"));

        Age.setCellValueFactory(new PropertyValueFactory<>("Age"));

        Height.setCellValueFactory(new PropertyValueFactory<>("Height"));

        Club.setCellValueFactory(new PropertyValueFactory<>("Club"));

        Position.setCellValueFactory(new PropertyValueFactory<>("Position"));

        Number.setCellValueFactory(new PropertyValueFactory<>("Number"));

        WeeklySalary.setCellValueFactory(new PropertyValueFactory<>("WeeklySalary"));

        playerToBeSoldTable.setItems(data);

//        playerToBeSoldTable.itemsProperty().bind(sellPlayerListProperty);

        //multi select mode on
        playerToBeSoldTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    public void handlePutInMarketPlaceButton(ActionEvent event) {
        ObservableList<Player> playersSelectedToBeSold = FXCollections.observableArrayList();
        if (!playerToBeSoldTable.getItems().isEmpty()) {
            playersSelectedToBeSold = playerToBeSoldTable.getSelectionModel().getSelectedItems();
        }
        //iterate through all the players in the list, create a sell Request for the player, write in write Thread

        if (!playersSelectedToBeSold.isEmpty()) {
            try {
                for (Player player : playersSelectedToBeSold
                ) {
                    //this removes from the table and the list in sellPlayerPageController, Main.sellablePlayerDB is done in responseHandler
                    playerToBeSoldTable.getItems().remove(player);
                    data.remove(player);

                    //create and send a sellPlayerRequest
                    sellPlayerRequest sellRequest = new sellPlayerRequest();
                    sellRequest.setClubSelling(Client.getClubName());
                    sellRequest.setPlayerToBeSold(player);
                    WriteThreadClient.write(sellRequest);
                }
            } catch (Exception e) {
                System.out.println("Error in buyPlayerPageController.sendBuyRequestButton: ");
                System.out.println("The selected player list: \n" + Arrays.toString(playersSelectedToBeSold.toArray()));
                System.out.println("Exception: " + e);
            }
        }
        //clear selection and refresh the table, hope it works
        playerToBeSoldTable.getSelectionModel().clearSelection();

        playerToBeSoldTable.refresh();
    }

    public void handleResetButton(ActionEvent event) {
        playerToBeSoldTable.getSelectionModel().clearSelection();
    }

    public void handleBackToMarketButton(ActionEvent event) {
        loadNewPage("marketPage", event);
    }

    @FXML void handleRefreshButton(ActionEvent event) {
        playerToBeSoldTable.getItems().clear();
//        playerToBeSoldTable.setItems(data);
//        System.out.println(Arrays.toString(playerToBeSoldTable.getItems().toArray()));
        playerToBeSoldTable.getColumns().clear();
        sellPlayerPageController.init(Main.getSellablePlayerDB());
        playerToBeSoldTable.getColumns().addAll(Name, Age, Country, Club, Position, Number, Height, WeeklySalary);
        playerToBeSoldTable.refresh();
    }
}
