package com.example.ademo;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Game of 21");
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}
