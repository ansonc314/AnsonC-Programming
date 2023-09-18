package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Requires the user login database exists.
 *
 */
public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
      String UserLoginName="";
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 450);
        stage.setTitle("Xpert Studio : Sign in ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        String UserLoginName="";
        launch();
    }
}