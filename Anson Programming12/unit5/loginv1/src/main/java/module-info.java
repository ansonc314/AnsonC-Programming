module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.commons.csv;


    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
    exports com.example.database;
    opens com.example.database to javafx.fxml;
    exports com.example.auxfiles;
    opens com.example.auxfiles to javafx.fxml;
}