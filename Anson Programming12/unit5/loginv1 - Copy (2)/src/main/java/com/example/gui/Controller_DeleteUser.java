package com.example.gui;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_DeleteUser {

    public Button exitButton, addUserButton;
    public void exit() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void submitAddUserForm(){
        System.out.println("SubmitAddUserForm");
        Stage stage = (Stage) addUserButton.getScene().getWindow();
        stage.close();

    }

}