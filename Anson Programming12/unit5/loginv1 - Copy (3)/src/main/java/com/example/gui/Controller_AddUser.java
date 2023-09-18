package com.example.gui;


import com.example.database.CSV_Handler;
import com.example.database.DerbyDatabase_Handler;
import com.example.database.DerbyTable_Handler;
import com.example.database.Record;
import com.example.database.RecordSet_Handler;
import com.example.globalVariables.StaticGlobalVariables;
import com.example.globalVariables.SystemInfo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller_AddUser {

    public TextField newUserName, newPassword, newFullName;

    public Button exitButton, addUserButton;
    public void exit() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("table-view.fxml"));
        Parent parent = loader.load();
        Controller_Table ctrl = loader.getController();
        ctrl.table_user.setText(StaticGlobalVariables.currentUser);

        stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("User Sign-In Database");
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void submitAddUserForm()  throws IOException {
        String userName = newUserName.getText();
        String password = newPassword.getText();
        String fullName = newFullName.getText();

        CSV_Handler csvFileHandle = new CSV_Handler(SystemInfo.csvFilename);
        DerbyDatabase_Handler handler = new DerbyDatabase_Handler(SystemInfo.databaseName);
        DerbyTable_Handler tableHandler = new DerbyTable_Handler(handler);

        // copy records from DB to hashmap
        RecordSet_Handler retrieveRS = tableHandler.Derby2RecordSet();
        retrieveRS.addRecord(new Record(new String[] {userName,password,fullName}));
        // update DB
        tableHandler.RecordSet2Derby( retrieveRS);
        // update csv file
        csvFileHandle.RecordSet2CSV(retrieveRS);

        System.out.println(userName);

        Stage stage = (Stage) addUserButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("table-view.fxml"));
        Parent parent = loader.load();
        Controller_Table ctrl = loader.getController();
        ctrl.table_user.setText(StaticGlobalVariables.currentUser);

        stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("User Sign-In Database");
        stage.setScene(new Scene(parent));
        stage.show();

    }

}