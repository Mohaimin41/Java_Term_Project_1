package controllers;

import database.Player;
import database.countryWisePlayers;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class countryWisePlayerCountController extends controller {
    @FXML
    TableView<countryWisePlayers> playerCountTable;
    @FXML
    TableColumn<countryWisePlayers, String> playerCountTableCountriesColumn;
    @FXML
    TableColumn<countryWisePlayers, Integer> playerCountTablePlayersColumn;

    @FXML
    Button backToPlayerSearchButton;
    @FXML
    Button backToMainButton;

    static ObservableList<countryWisePlayers> data = FXCollections.observableArrayList();
    //binding property
    private Property<ObservableList<countryWisePlayers>> countryStatTableProperty = new SimpleObjectProperty<>(data);

    static void init(List<countryWisePlayers> countryWisePlayerCount) {
       data.clear();
       data.addAll(countryWisePlayerCount);
    }

    @FXML
    public void initialize() {
        playerCountTableCountriesColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        playerCountTablePlayersColumn.setCellValueFactory(new PropertyValueFactory<>("playerCount"));
        playerCountTable.setItems(data);
        playerCountTable.itemsProperty().bind(countryStatTableProperty);
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
