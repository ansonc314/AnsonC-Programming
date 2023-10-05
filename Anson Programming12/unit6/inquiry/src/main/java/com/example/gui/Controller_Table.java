package com.example.gui;

import com.example.database.*;
import com.example.globalVariables.StaticGlobalVariables;
import com.example.globalVariables.SystemInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class Controller_Table implements Initializable {

    public Label lbl_avgWeight, lbl_avgSBP, lbl_avgDBP;
    public Label table_user;
    public Button addButton;
    public Button exitButton;
    public TableView mainTable;
    public TableColumn colWeight;
    public TableColumn colBMI;
    public TableColumn colSBP;
    public TableColumn colDBP;

    ObservableList<SimpleStringRecord> userList;


    /**
     * This method will be called to load the user sign in information and display in a table
     * @param url
     * @param resourceBundle
     */
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
        List_Handler_data recordSetList = retrieveList();

        ListIterator iterator = recordSetList.recordSet.listIterator();

        // loop through the recordSet and add to the ObservableList.
        while (iterator.hasNext()){
            Record_data temp1 = (Record_data) iterator.next();
            String[] temp = temp1.getRecord();
            userList.add(new SimpleStringRecord(temp[0] , temp[1], temp[2], temp[3] ));

        }

        Double tmp1 =  recordSetList.returnAverage(0);
        lbl_avgWeight.setText(tmp1.toString());
        Double tmp2 =  recordSetList.returnAverage(2);
        lbl_avgSBP.setText(tmp2.toString());
        Double tmp3 =  recordSetList.returnAverage(3);
        lbl_avgDBP.setText(tmp3.toString());

    }

    /**
     * Initialize the column name of the table
     */
    private void initCol() {
        colWeight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        colBMI.setCellValueFactory(new PropertyValueFactory<>("BMI"));
        colSBP.setCellValueFactory(new PropertyValueFactory<>("SBP"));
        colDBP.setCellValueFactory(new PropertyValueFactory<>("DBP"));
    }


    /**
     * When the add user button is added, a new AddUser window will be created
     * @throws IOException
     */
   public void buttonAddUser()  throws IOException {
       Stage stage = (Stage) addButton.getScene().getWindow();
       stage.close();


       Parent parent = FXMLLoader.load(getClass().getResource("addData-view.fxml"));
       stage = new Stage(StageStyle.DECORATED);
       stage.setTitle("Enter New User Details");
       stage.setScene(new Scene(parent));
       stage.show();

    }


    /**
     * The method will be called when the user wants to quit the program.
     * An exit window will be displayed where the user will be asked again to confirm if he wants to exit or not
     * @throws IOException
     */
    public void buttonExit() throws IOException{

        Parent parent = FXMLLoader.load(getClass().getResource("exit-warning-view.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Signing Out");
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private List_Handler_data retrieveList(){
        //load all user names and passwords record
        DerbyDatabase_Handler_data handler = new DerbyDatabase_Handler_data(SystemInfo.databaseName_data);
        DerbyTable_Handler_data tableHandler = new DerbyTable_Handler_data(handler, StaticGlobalVariables.currentDataTableName);

        List_Handler_data recordSetList = tableHandler.Derby2RecordSet();
        return recordSetList;
    }



}
