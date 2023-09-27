package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Requires the user login database exists.
 * If run for the first time,the method test_DB_data in the package com.example.database can be called to
 * copy the .csv file to the database
 * Once the DB was created, there is no need to re-run the program. All updates in the sign-in records will
 * simultaneously update the database and the csv files.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 450);
        stage.setTitle("Xpert Studio : Sign in ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}