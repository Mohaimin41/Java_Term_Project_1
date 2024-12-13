package controllers;

import client.Main;
import database.Player;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;
import java.util.List;

public class playerTableController extends controller {
    @FXML Button refreshButton;
    @FXML
    Label playerTableHeader;
    @FXML
    TableView<Player> playerTable;
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

    static ObservableList<Player> data = FXCollections.observableArrayList();
    //binding property
    private Property<ObservableList<Player>> playerListProperty = new SimpleObjectProperty<>(data);

    @FXML
    Button backToPlayerSearchButton;
    @FXML
    Button backToClubSearchButton;
    @FXML
    Button backToMainButton;

//    private Main main;

    private static playerTableController instance = null;

    public playerTableController() {}

    public static playerTableController getInstance() {
        if (instance == null) {
            instance = new playerTableController();
        }
        return instance;
    }

    public static void init(List<Player> playerData) {
        data.clear();
//        data.addAll(playerData);
        data.setAll(playerData);
    }

    public TableView<Player> getPlayerTable() {
        return playerTable;
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

        playerTable.setItems(data);

//        playerTable.itemsProperty().bind(playerListProperty);
    }

    @FXML
    void backToPlayerSearch(ActionEvent actionEvent) {
        loadNewPage("playerSearchPage", actionEvent);
    }

    @FXML
    void backToClubSearch(ActionEvent actionEvent) {
        loadNewPage("clubSearchPage", actionEvent);
    }

    @FXML
    void backToMain(ActionEvent actionEvent) {
        loadNewPage("mainPage", actionEvent);
    }

    @FXML void handleRefreshButton(ActionEvent event) {
        playerTable.getItems().clear();
//        playerTable.setItems(data);
        playerTable.getColumns().clear();
        playerTableController.init(Main.getPlayerDB());
        playerTable.setItems(data);
        playerTable.getColumns().addAll(Name, Age, Country, Club, Position, Number, Height, WeeklySalary);
        playerTable.refresh();

    }
}
