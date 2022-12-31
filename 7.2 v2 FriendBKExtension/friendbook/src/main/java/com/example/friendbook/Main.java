package com.example.friendbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.*;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Friendbook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Friendbook");
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(625);
        stage.show();

        ChoiceBox display_choice = new ChoiceBox();
        display_choice.getItems().addAll("item1", "item2", "item3");

     Friend b1 = new Friend("a","b","c");
     Friend b2 = new Friend("x","y","z");
     b2 = b1;
     b2.name = "w";
     System.out.println(b1.name);
     }


    public static void main(String[] args) {launch();
    }
}