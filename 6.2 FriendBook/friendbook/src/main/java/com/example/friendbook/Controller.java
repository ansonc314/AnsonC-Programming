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
        // Requires: Mouse selection of an item in the friendList
        // Effects: 1) display the name, phone and email of the selected friend.
        //          2) enable the delete button.

        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        lbl_ListShowName.setText(temp.name);
        lbl_ListShowPhone.setText(temp.phone);
        lbl_ListShowEmail.setText(temp.email);
        show_index = friendList.getSelectionModel().getSelectedIndex();
        button_delete.setDisable(false);
    }
    public void deleteFriend(){
        // Requires: An item/friend was selected in the list and the disable button is enabled.
        // Modifies: friendList
        // Effects:  1) Removed the selected item from the friendList
        //           2) Disable the delete button to prevent further deletion before another friend is selected
        friendList.getItems().remove(show_index);
        lbl_ListShowName.setText("");
        lbl_ListShowPhone.setText("");
        lbl_ListShowEmail.setText("");
        button_delete.setDisable(true);
    }

}