package com.example.gui;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_Help {

    /*
    This class controls the help windows
    */
    public Button exitButton;
    public void exit() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


}