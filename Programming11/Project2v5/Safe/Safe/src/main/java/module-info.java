module com.example.safe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.safe to javafx.fxml;
    exports com.example.safe;
}