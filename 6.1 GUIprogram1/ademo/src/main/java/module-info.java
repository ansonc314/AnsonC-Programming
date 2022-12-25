module com.example.ademo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ademo to javafx.fxml;
    exports com.example.ademo;
}