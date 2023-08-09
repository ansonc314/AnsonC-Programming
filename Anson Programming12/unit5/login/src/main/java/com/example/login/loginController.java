package com.example.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class loginController {
    @FXML
    private Label welcomeText;

    public void exitSystem() {
        System.exit(1);
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}