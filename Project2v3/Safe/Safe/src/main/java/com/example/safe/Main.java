package com.example.safe;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import javafx.collections.;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Password Safe");
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(625);
        stage.show();

        data instruction = new data ("instruction.txt");
        instruction.create_line_array();
        System.out.println(instruction.read2string());
    }

    public static void main(String[] args) {launch();
    }
}