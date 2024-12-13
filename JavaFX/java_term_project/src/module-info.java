module java.term.project {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
//    exports controllers to javafx.fxml;
    opens client to javafx.graphics, javafx.fxml, javafx.controls, javafx.base;
    opens controllers to javafx.graphics, javafx.fxml, javafx.controls, javafx.base;
    opens views to javafx.graphics, javafx.fxml, javafx.controls, javafx.base;
    opens values to javafx.graphics, javafx.fxml, javafx.controls, javafx.base;
    opens database to javafx.graphics, javafx.fxml, javafx.controls, javafx.base;
}