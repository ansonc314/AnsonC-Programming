package com.example.friendbook;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Controller {
    int show_index_home, show_index_work, show_index_bank;   // index of friend list for the friend to be displayed/deleted

    public TextField text_addGetName, text_addGetPhone, text_addGetEmail;
    public Label lbl_ListShowName_home, lbl_ListShowPhone_home, lbl_ListShowEmail_home;
    public Label lbl_ListShowName_work, lbl_ListShowPhone_work, lbl_ListShowEmail_work;
    public Label lbl_ListShowName_bank, lbl_ListShowPhone_bank, lbl_ListShowEmail_bank;
    public ListView<Friend> friendList_home = new ListView<Friend>();
    public ListView<Friend> friendList_work = new ListView<Friend>();
    public ListView<Friend> friendList_bank = new ListView<Friend>();
    public Button button_delete_home, button_delete_work, button_delete_bank;
    public ChoiceBox cbox_display_choice, cbox_add_choice;

    public void addFriend(){
        /*  Requires: Strings (name, phone and email) from text fields
            Modifies: friendList
            Effects: create a friend object and add to the friendList and
                  reset the text fields
        */
        ListView<Friend> local = friendList_home;
        String choice ="";
        choice = cbox_add_choice.getSelectionModel().getSelectedItem().toString();
        switch(choice) {
            case "Home":
                local = friendList_home;
                break;
            case "Work":
                local = friendList_work;
                break;
            case "Bank":
                local = friendList_bank;
        }


        String name = text_addGetName.getText();
        String phone = text_addGetPhone.getText();
        String email = text_addGetEmail.getText();
        Friend temp = new Friend(name, phone, email);
        local.getItems().add(temp);
        text_addGetName.clear();
        text_addGetPhone.clear();
        text_addGetEmail.clear();
    }
    public void displayFriend_home(){
        // Requires: Mouse selection of an item in the friendList
        // Effects: 1) display the name, phone and email of the selected friend.
        //          2) enable the delete button.
        ListView<Friend> local;

        local = friendList_home;
        Friend temp;
        temp = local.getSelectionModel().getSelectedItem();
        lbl_ListShowName_home.setText(temp.name);
        lbl_ListShowPhone_home.setText(temp.phone);
        lbl_ListShowEmail_home.setText(temp.email);
        show_index_home = local.getSelectionModel().getSelectedIndex();
        button_delete_home.setDisable(false);
    }

    public void deleteFriend_home(){
        // Requires: An item/friend was selected in the list and the disable button is enabled.
        // Modifies: friendList
        // Effects:  1) Removed the selected item from the friendList
        //           2) Disable the delete button to prevent further deletion before another friend is selected

        ListView<Friend> local;
        local = friendList_home;
        local.getItems().remove(show_index_home);
        lbl_ListShowName_home.setText("");
        lbl_ListShowPhone_home.setText("");
        lbl_ListShowEmail_home.setText("");
        button_delete_home.setDisable(true);
    }

    public void load_home() throws IOException  {
    Data list = new Data("home.txt");
    list.friendList = friendList_home;
    list.read2lines();
    }

    public void save_home()  throws IOException  {
        Data list = new Data("home.txt");
        list.friendList = friendList_home;
        list.write2txt();
    }

  

}