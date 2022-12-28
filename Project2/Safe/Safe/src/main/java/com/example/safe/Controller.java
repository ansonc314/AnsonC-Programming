package com.example.safe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    int show_index;   // index of friend list for the friend being displayed

    @FXML     public TextField text_addGetName, text_addGetPhone, text_addGetEmail;
    @FXML     public TextField text_deleteGetName, text_deleteGetPhone, text_deleteGetEmail;
    @FXML     public TextField text_ListShowName, text_ListShowPhone, text_ListShowEmail;
    @FXML     public ListView<Friend> friendList = new ListView<Friend>();


    public void addFriend(ActionEvent actionEvent){
        String name = text_addGetName.getText();
        String phone = text_addGetPhone.getText();
        String email = text_addGetEmail.getText();
        Friend temp = new Friend(name, phone, email);
        friendList.getItems().add(temp);
        text_addGetName.clear();
        text_addGetPhone.clear();
        text_addGetEmail.clear();

    }
    public void displayFriend(){
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        text_ListShowName.setText(temp.name);
        text_ListShowPhone.setText(temp.phone);
        text_ListShowEmail.setText(temp.email);
        show_index = friendList.getSelectionModel().getSelectedIndex();
    }

    public void deleteFriend(){
        friendList.getItems().remove(show_index);
        text_ListShowName.clear();
        text_ListShowPhone.clear();
        text_ListShowEmail.clear();
    }

}