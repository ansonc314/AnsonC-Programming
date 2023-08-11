package com.example.gui;

import com.example.database.*;
import com.example.database.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public Button deleteButton;
    public Button exitButton;
    public TableView mainTable;
    public TableColumn colName;
    public TableColumn colStatus;
    public TableColumn colOccupation;
    public ObservableList<Person> people;
    public ObservableList<SimpleStringRecord> recordsObvList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recordsObvList = FXCollections.observableArrayList();
        people = FXCollections.observableArrayList();
        initCol();
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        for(int i = 0 ; i < 10;i++){
            String name = "Name " + i;
            String status = "status " + i;
            String occ = "occupation " + i;

//            people.add(new Person(name, status, occ));
        }

//        mainTable.getItems().setAll(people);
        CSV_Handler csvFileHandle = new CSV_Handler();
        DerbyDatabaseHandler handler = new DerbyDatabaseHandler();
        DerbyTableHandler tableHandler = new DerbyTableHandler(handler);

        RecordSetHandler retr = tableHandler.Derby2RecordSet(); // read data from database to recordSet
        Iterator<String> iterator = retr.recordSet.keySet().iterator();
        while (iterator.hasNext()){
            //SimpleStringRecord temp = new SimpleStringRecord(retr.recordSet.get(iterator.next()).getRecord());
            String[] temp = retr.recordSet.get(iterator.next()).getRecord();
            people.add(new Person(temp[0] , temp[1], temp[2]));
            //recordsObvList.add(temp);
        }
        mainTable.getItems().setAll(people);

    }


    private void initCol() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colOccupation.setCellValueFactory(new PropertyValueFactory<>("occupation"));
    }


   public void buttonAddUser()  throws IOException {
        System.out.println("button AddUser pressed");
        Parent parent = FXMLLoader.load(getClass().getResource("addUser-view.fxml"));
       Stage stage = new Stage(StageStyle.DECORATED);
       stage.setTitle("title");
       stage.setScene(new Scene(parent));
       stage.show();
    }

    public void buttonDeleteUser() throws IOException{
        System.out.println("button DeleteUser pressed");
        Parent parent = FXMLLoader.load(getClass().getResource("deleteUser-view.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Delete User");
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void buttonExit() throws IOException{
        System.out.println("button EXIT pressed");
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


}
