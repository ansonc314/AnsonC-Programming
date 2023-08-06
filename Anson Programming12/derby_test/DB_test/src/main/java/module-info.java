module com.db.db_test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.db.db_test to javafx.fxml;
    exports com.db.db_test;
}