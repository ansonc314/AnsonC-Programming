module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
    exports com.example.database;
    opens com.example.database to javafx.fxml;
}