package com.example.friendbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import java.io.*;

import java.io.IOException;
import java.util.ArrayList;

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

        Data a = new Data("file.txt");


        //a.read2lines();
        ArrayList<String> lines = new ArrayList<>();
        lines = a.lines;
        a.lines.add("abc");
        a.lines.add("xyz");
        a.write2txt();
     }


    public static void main(String[] args) {launch();
    }
}