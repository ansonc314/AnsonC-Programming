package com.example.friendbook;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    int show_index;   // index of friend list for the friend to be displayed/deleted

    @FXML     public TextField text_addGetName, text_addGetPhone, text_addGetEmail;
    @FXML     public Label lbl_ListShowName, lbl_ListShowPhone, lbl_ListShowEmail;
    @FXML     public ListView<Friend> friendList = new ListView<Friend>();
    @FXML     public Button button_delete;

    public void addFriend(){
        // Requires: Strings (name, phone and email) from text fields
        // Modifies: friendList
        // Effects: create a friend object and add to the friendList and
        //          reset the text fields

        String name = text_addGetName.getText(); // get friend's detail
        String phone = text_addGetPhone.getText();
        String email = text_addGetEmail.getText();
        Friend temp = new Friend(name, phone, email);  // create a friend object with the details
        friendList.getItems().add(temp);  // add the friend to the list
        text_addGetName.clear();           // reset the TextField to blank again
        text_addGetPhone.clear();
        text_addGetEmail.clear();

    }
    public void displayFriend(){
        /* Requires: Mouse selection of an item in the friendList
           Modifies: show_index
           Effects: 1) the value of the show_index is set
                    2) display the name, phone and email of the selected friend.
                    3) enable the delete button.
         */

        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();  // extracted the friend object from list
        lbl_ListShowName.setText(temp.name);                     // display the friend's info.
        lbl_ListShowPhone.setText(temp.phone);
        lbl_ListShowEmail.setText(temp.email);
        show_index = friendList.getSelectionModel().getSelectedIndex();  // get index of the object
        button_delete.setDisable(false);                        // enable delete button
    }
    public void deleteFriend(){
        // Requires: An item/friend was selected in the list and the disable button is enabled.
        // Modifies: friendList
        // Effects:  1) Removed the selected item from the friendList
        //           2) Disable the delete button to prevent further deletion before another friend is selected
        friendList.getItems().remove(show_index);      // remove the friend object from list
        lbl_ListShowName.setText("");                  // clear the display field
        lbl_ListShowPhone.setText("");
        lbl_ListShowEmail.setText("");
        button_delete.setDisable(true);                 // disable the delete button
    }

}