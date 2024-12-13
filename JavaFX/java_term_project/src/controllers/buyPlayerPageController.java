package controllers;

import client.Client;
import client.Main;
import client.WriteThreadClient;
import database.Player;
import dto.buyPlayerRequest;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;
import java.util.List;

public class buyPlayerPageController extends controller{
    @FXML Button refreshButton;
    @FXML
    Label playerTableHeader;
    @FXML TableView<Player> playerToBeBoughtTable;
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

    @FXML Button sendBuyRequestButton;
    @FXML Button resetButton;
    @FXML Button backToMarketButton;

    static ObservableList<Player> data = FXCollections.observableArrayList();
    //Property needed for binding the list
    private final Property<ObservableList<Player>> buyPlayerListProperty = new SimpleObjectProperty<>(data);

    private static buyPlayerPageController instance = null;

    public buyPlayerPageController() {}

    public static buyPlayerPageController getInstance(){
        if (instance == null) {
            instance = new buyPlayerPageController();
        }
        return instance;
    }

    public static void init(List<Player> playerData) {
        data.clear();
//        data.addAll(playerData);
        data.setAll(playerData);
    }

    public TableView<Player> getPlayerToBeBoughtTable() {
        return playerToBeBoughtTable;
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

        playerToBeBoughtTable.setItems(data);

//        playerToBeBoughtTable.itemsProperty().bind(buyPlayerListProperty);

        //multi selection on
        playerToBeBoughtTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }


    @FXML void handleSendBuyRequestButton(ActionEvent event) {
        ObservableList<Player> playersSelectedToBeBought =  FXCollections.observableArrayList();
        if (!playerToBeBoughtTable.getItems().isEmpty()) {
            playersSelectedToBeBought = playerToBeBoughtTable.getSelectionModel().getSelectedItems();
        }
        //iterate through all the players in the list, create a buy Request for the player, write in write Thread

        if (!playersSelectedToBeBought.isEmpty()) {
            try {
                for (Player player : playersSelectedToBeBought
                ) {
                    //remove from the table and the list at Controller
                    playerToBeBoughtTable.getItems().remove(player);
                    data.remove(player);
                    playerToBeBoughtTable.refresh();
                    Main.getMarketDB().remove(player);

                    //create and send a buyPlayerRequest
                    buyPlayerRequest buyRequest = new buyPlayerRequest();
                    buyRequest.setClubBuying(Client.getClubName());
                    buyRequest.setPlayerToBeBought(player);
                    WriteThreadClient.write(buyRequest);
                }
            } catch (Exception e) {
                System.out.println("Error in buyPlayerPageController.sendBuyRequestButton: ");
                System.out.println("The selected player list: \n" + Arrays.toString(playersSelectedToBeBought.toArray()));
                System.out.println("Exception: " + e);
            }
        }
        //clear selection and refresh the table, hope it works
        playerToBeBoughtTable.getSelectionModel().clearSelection();
        playerToBeBoughtTable.refresh();
    }

    @FXML void handleResetButton(ActionEvent event) {
        playerToBeBoughtTable.getSelectionModel().clearSelection();
    }

    @FXML void handleBackToMarketButton(ActionEvent event) {
        loadNewPage("marketPage", event);
    }

    @FXML void handleRefreshButton(ActionEvent event) {
        playerToBeBoughtTable.getItems().clear();
//        playerToBeBoughtTable.setItems(data);
        playerToBeBoughtTable.getColumns().clear();
        buyPlayerPageController.init(Main.getMarketDB());
        playerToBeBoughtTable.getColumns().addAll(Name, Age, Country, Club, Position, Number, Height, WeeklySalary);
        playerToBeBoughtTable.refresh();
    }
}
