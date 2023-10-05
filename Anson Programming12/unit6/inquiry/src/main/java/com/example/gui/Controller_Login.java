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

public class Controller_Login {
    /*
    This class controls the login windows
     */
    public TextField userName_loginWin, password_loginWin;
    public Button buttonLogin, buttonHelp;


    public void initialize() throws IOException {
    }


    /**
     * this method will be execute when login button pressed,
     * The system will match the info about username and password with records in the database
     * If info matches, it will create a new windows
     * Or else, an error message will be printed
     * @throws IOException
     */
    public void loginButtonPressed() throws IOException {

        String userName = userName_loginWin.getText();
        String password = password_loginWin.getText();

        // define the derby database handler for checking if entered username and password matches DB records or not

        DerbyDatabase_Handler_user handler = new DerbyDatabase_Handler_user(SystemInfo.databaseName_user);
        DerbyTable_Handler_user tableHandler = new DerbyTable_Handler_user(handler,SystemInfo.databaseTableName_user);


        if (tableHandler.recordExist(userName,password)){
            // sign-in is successful. A new window with all user  info will be displayed
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-view.fxml"));

            Parent parent = loader.load();
            Controller_Table ctrl = loader.getController();
            ctrl.table_user.setText(StaticGlobalVariables.currentUser);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Health Tracker");
            stage.setScene(new Scene(parent));
            stage.show();

            // close the login window
            Stage stage_current = (Stage) buttonLogin.getScene().getWindow();
            stage_current.close();
        }else {
            // in case of sign-in error, a new error window will display
            Parent parent = FXMLLoader.load(getClass().getResource("signin-warning-view.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Warning");
            stage.setScene(new Scene(parent));
            stage.show();
        }

    }


    /**
     * this method will be execute when help button was pressed,
     * A help window will be displayed
     * @throws IOException
     */
    public void openHelpWindow()  throws IOException  {
        Parent parent = FXMLLoader.load(getClass().getResource("help-view.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Instructions");
        stage.setScene(new Scene(parent));
        stage.show();
    }



}