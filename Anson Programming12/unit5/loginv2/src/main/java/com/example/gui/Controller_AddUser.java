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

/**
 * This controller controls the add-user window.
 * There are two functions - add users to the database and exit the add-user window
 */
public class Controller_AddUser {

    public TextField newUserName, newPassword, newFullName;
    public Button exitButton, addUserButton;

    /**
     * The method will run when exit button is pressed
     * @throws IOException
     */
    public void exit() throws IOException {
        CloseAndReturn();
    }


    /**
     * This method will run when the submit button is pressed
     * @throws IOException
     */
    public void submitAddUserForm()  throws IOException {

        String userName = newUserName.getText();
        String password = newPassword.getText();
        String fullName = newFullName.getText();

        // define csv, derbyDB handlers which will be used for adding records
        CSV_Handler csvFileHandle = new CSV_Handler(SystemInfo.csvFilename);
        DerbyDatabase_Handler handler = new DerbyDatabase_Handler(SystemInfo.databaseName);
        DerbyTable_Handler tableHandler = new DerbyTable_Handler(handler);

        // copy records from DB to hashmap
        RecordSet_Handler retrieveRS = tableHandler.Derby2RecordSet();
        // add record the hashmap
        retrieveRS.addRecord(new Record(new String[] {userName,password,fullName}));
        // add record to derby DB from hashmap
        tableHandler.RecordSet2Derby( retrieveRS);
        // add record to .csv from hashmap
        csvFileHandle.RecordSet2CSV(retrieveRS);

        CloseAndReturn();

    }

    public void CloseAndReturn()  throws IOException {
        // close the add-user window
        Stage stage = (Stage) addUserButton.getScene().getWindow();
        stage.close();

        // re-display the table-view window (the screen showing all user login info)
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