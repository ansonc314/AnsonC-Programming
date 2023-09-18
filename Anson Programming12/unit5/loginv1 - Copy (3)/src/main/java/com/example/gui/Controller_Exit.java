package com.example.gui;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_Exit {

    /*
    This class controls the help windows
    */
    public Button exitWindow_exitButton, exitWindow_cancelButton;

    public void exit() throws IOException {
        Stage stage = (Stage) exitWindow_exitButton.getScene().getWindow();
        stage.close();
        System.exit(1);

    }

    public void cancel() throws IOException {
        Stage stage = (Stage) exitWindow_cancelButton.getScene().getWindow();
        stage.close();
    }


}