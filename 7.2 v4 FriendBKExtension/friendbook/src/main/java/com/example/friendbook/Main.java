package com.example.friendbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
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

    //    Data a = new Data("file.txt");

        ListView<Friend> alist = new ListView<Friend>();
        alist.getItems().add(new Friend("a","b","c"));
        alist.getItems().add(new Friend("x","y","z"));

//        ObservableList b = alist.getItems();



        /*
        ArrayList<String> lines = new ArrayList<>();
        lines = a.lines;
        lines.add("abc");
        lines.add("xyz");

        a.set_lines(lines);
        a.write2txt();

         */
     }


    public static void main(String[] args) {launch();
    }
}