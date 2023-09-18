package com.example.gui;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_Exit {

    /*
    This class controls the exit window
    */
    public Button exitWindow_exitButton, exitWindow_cancelButton;

    public void exit() throws IOException {
        // exit the program
        System.exit(1);

    }

    public void cancel() throws IOException {
        // close the exit window
        Stage stage = (Stage) exitWindow_cancelButton.getScene().getWindow();
        stage.close();
    }


}