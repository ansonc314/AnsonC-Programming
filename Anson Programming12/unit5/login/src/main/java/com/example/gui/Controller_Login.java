package com.example.gui;

import com.example.database.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller_Login {

    public void initialize() throws IOException {
        System.out.println("initialize ... ");

        CSV_Handler csvFileHandle = new CSV_Handler();
        DerbyDatabaseHandler handler = new DerbyDatabaseHandler();
        DerbyTableHandler tableHandler = new DerbyTableHandler(handler);

        // test 1: CSV - ReSet - DB
        RecordSetHandler recordSetHandler = csvFileHandle.CSV2RecordSet(); // csv 2 recordSet
        tableHandler.RecordSet2Derby(recordSetHandler);  //RecordSet 2 DB
        tableHandler.printMembers();


        // test 2: DB - ReSET - CSV

        RecordSetHandler retr = tableHandler.Derby2RecordSet();
        csvFileHandle.RecordSet2CSV(retr);
        retr.printRecordSet();




    }

    @FXML
    private Label welcomeText;

    public void openTableWindow() throws IOException {
        //System.exit(1);
        Parent parent = FXMLLoader.load(getClass().getResource("table-view.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("title");
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void openHelpWindow()  throws IOException  {
        //System.exit(1);
        System.out.println("Help button pressed");
        Parent parent = FXMLLoader.load(getClass().getResource("table-view.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("title");
        stage.setScene(new Scene(parent));
        stage.show();
    }



}