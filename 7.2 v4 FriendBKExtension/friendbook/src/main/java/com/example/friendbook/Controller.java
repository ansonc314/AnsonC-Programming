package com.example.friendbook;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Controller {
    int show_index_home;   // index of friend list for the friend to be displayed/deleted

    public TextArea tarea_instruction;
    public TextField text_group, text_addGetName, text_addGetPhone, text_addGetEmail;
    public Label lbl_ListShowName_home, lbl_ListShowPhone_home, lbl_ListShowEmail_home;
    public ListView<Friend> friendList_home = new ListView<Friend>();
    public Button button_delete_home;


    @FXML
    public void initialize() {
        String str =
                  "1) To save a list to a file\n" +
                          "\ta) Choose the group name  \n" +
                          "\tb) Click the save button   \n" +
                          "\tc) The current friend list will save to a file, where the file name is the group name. e.g., if group name is home, the file is called home.txt  \n" +
                          "2) To load the list from a file\n" +
                          "\ta) Choose the group name  \n" +
                          "\tb) Click the load button   \n" +
                          "\tc) The list will be loaded using the corresponding data file. e.g., if group name is home, the file is called home.txt  \n" +
                          "3) To add a friend to a list\n" +
                          "\ta) Choose the group name  \n" +
                          "\tb) Enter the friend's details and press add button.   \n" +
                          "\tc) The friend will be added to the current list. Remember to save the list after all editing. \n" +
                          "4) To clear a list\n" +
                          "\ta) Use the clear button  \n" +
                          "   ";
        tarea_instruction.setText(str);
    }
    public void clearFriend(){
        friendList_home.getItems().clear();
    }
    public void addFriend(){
        /*  Requires: Strings (name, phone and email) from text fields
            Modifies: friendList
            Effects: create a friend object and add to the friendList and
                  reset the text fields
        */

        String name = text_addGetName.getText();
        String phone = text_addGetPhone.getText();
        String email = text_addGetEmail.getText();
        Friend temp = new Friend(name, phone, email);
        friendList_home.getItems().add(temp);
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
        String str = text_group.getText();
        Data list = new Data(str + ".txt");
        list.friendList = friendList_home;
        list.read2lines();
    }

    public void save_home()  throws IOException  {
        String str = text_group.getText();
        Data list = new Data(str + ".txt");
        list.friendList = friendList_home;
        list.write2txt();
    }



}