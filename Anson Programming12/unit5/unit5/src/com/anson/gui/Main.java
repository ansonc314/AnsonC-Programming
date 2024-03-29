package com.anson.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


      Parent root = FXMLLoader.load(Main.class.getResource("/fxml/mainWindow.fxml"));
        stage.setTitle("Title");
        stage.setScene(new Scene(root, 300, 300));
        stage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
