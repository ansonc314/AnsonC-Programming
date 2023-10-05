package com.example.gui;


import com.example.database.*;
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
public class Controller_AddData {

    public TextField newWeight, newSBP, newDBP;
    public Button exitButton, addUserButton;

    /**
     * The method will run when exit button is pressed
     * @throws IOException
     */
    public void exitAddDataForm() throws IOException {
        CloseAndReturn();
    }


    /**
     * This method will run when the submit button is pressed
     * @throws IOException
     */
    public void submitAddDataForm()  throws IOException {

        String weight = newWeight.getText();
        String SBP = newSBP.getText();
        String DBP = newDBP.getText();

        // define csv handlers which will be used for adding records

        CSV_Handler_data csvFileHandle = new CSV_Handler_data(StaticGlobalVariables.currentDataTableName);
        List_Handler_data recordSetList = csvFileHandle.CSV2RecordSet();

        Double h =  Double.valueOf(StaticGlobalVariables.currentHeight);
        Double w =  Double.valueOf(weight);
        Double bmi = 100*100*w/(h*h);
        bmi = Math.round(bmi*100)/100.0;

        Record_data temp = new Record_data(new String[]{weight, bmi.toString() , SBP, DBP});
        recordSetList.addRecord2First(temp);

        // add record to .csv from hashmap
        csvFileHandle.RecordSet2CSV(recordSetList);

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
        stage.setTitle("Health Tracker");
        stage.setScene(new Scene(parent));
        stage.show();
    }


}