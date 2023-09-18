package com.example.gui;

import com.example.database.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Controller_Table implements Initializable {

    public Label table_user;
    public Button addButton;
    public Button exitButton;
    public TableView mainTable;
    public TableColumn colUserName;
    public TableColumn colPassword;
    public TableColumn colFullName;
    ObservableList<SimpleStringRecord> userList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userList = FXCollections.observableArrayList();
        initCol();
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display the userList in the table
        mainTable.getItems().setAll(userList);

    }

    /**
     * load the sign-in records and put them in the observableArrayList userList
     */
    private void loadData() {
        //load all user names and passwords record
        DerbyDatabase_Handler handler = new DerbyDatabase_Handler();
        DerbyTable_Handler tableHandler = new DerbyTable_Handler(handler);
        RecordSet_Handler recordSetList = tableHandler.Derby2RecordSet(); // read data from database to recordSet
        Iterator<String> iterator = recordSetList.recordSet.keySet().iterator();

        // loop through the recordSet and add to the ObservableList.
        while (iterator.hasNext()){
            String[] temp = recordSetList.recordSet.get(iterator.next()).getRecord();
            userList.add(new SimpleStringRecord(temp[0] , temp[1], temp[2]));

        }

    }

    /**
     * Initialize the column name of the table
     */
    private void initCol() {
        colUserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
    }


    /**
     * When the add user button is added, a new window will be created
     * @throws IOException
     */
   public void buttonAddUser()  throws IOException {
       Stage stage = (Stage) addButton.getScene().getWindow();
       stage.close();

       Parent parent = FXMLLoader.load(getClass().getResource("addUser-view.fxml"));
       stage = new Stage(StageStyle.DECORATED);
       stage.setTitle("Enter New User Details");
       stage.setScene(new Scene(parent));
       stage.show();
    }


    public void buttonExit() throws IOException{
//        Stage stage = (Stage) exitButton.getScene().getWindow();
//        stage.close();

        Parent parent = FXMLLoader.load(getClass().getResource("exit-warning-view.fxml"));
       Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Signing Out");
        stage.setScene(new Scene(parent));
        stage.show();
    }


}
