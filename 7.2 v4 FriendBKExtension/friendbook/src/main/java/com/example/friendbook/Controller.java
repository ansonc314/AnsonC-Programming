package com.example.friendbook;

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
    /*
    friendList_home contains the list of friends.
     */

    public void initialize() {
    /* Effects: Display instructions on the TextArea tarea_instruction
     */
        String str =
                  "1) To save a list to a file\n" +
                          "1.a) Choose the group name (e.g. home) \n" +
                          "1.b) Click the save button   \n" +
                          "1.c) The current friend list will save to a file, where the file name is the group name. e.g., if group name is home, the file is called home.txt  \n" +
                          "2) To load the list from a file\n" +
                          "2.a) Choose the group name  \n" +
                          "2.b) Click the load button   \n" +
                          "2.c) The list will be loaded using the corresponding data file. e.g., if group name is home, the file is called home.txt  \n" +
                          "3) To add a friend to a list\n" +
                          "3.a) Choose the group name  \n" +
                          "3.b) Enter the friend's details and press add button.   \n" +
                          "4) To delete a friend from a list\n" +
                          "4.a) Select the friend from the list and details of the friend will be displayed\n" +
                          "4.c) Press delete and the friend will be removed from the current list. Remember to save the list after all editing. \n" +
                          "5) To clear a list\n" +
                          "5.a) Use the clear button  \n" +
                          "   ";
        tarea_instruction.setText(str);
    }
    public void clearFriend(){
    /*
    Modifies: ListView friendList_home
    Effects: Clear the list friendList_home
     */
        friendList_home.getItems().clear();
        lbl_ListShowName_home.setText("");
        lbl_ListShowPhone_home.setText("");
        lbl_ListShowEmail_home.setText("");
    }
    public void addFriend(){
        /*  Requires: Strings (name, phone and email) from text fields. Requires the group not to be empty
            Modifies: friendList
            Effects: create a friend object and add to the friendList and
                  reset the text fields
        */

        String name = text_addGetName.getText();            // get friend's detail
        String phone = text_addGetPhone.getText();
        String email = text_addGetEmail.getText();
        Friend temp = new Friend(name, phone, email);       // create a friend object with the details
        friendList_home.getItems().add(temp);               // add the friend to the list
        text_addGetName.clear();                            // reset the TextField to blank again
        text_addGetPhone.clear();
        text_addGetEmail.clear();
    }
    public void displayFriend_home(){
        /* Requires: Mouse selection of an item in the friendList
           Modifies: show_index_home
           Effects: 1) the value of the show_index_home is set
                    2) display the name, phone and email of the selected friend.
                    3) enable the delete button.
         */
        Friend temp;
        temp = friendList_home.getSelectionModel().getSelectedItem();  // extracted the friend object from list
        lbl_ListShowName_home.setText(temp.name);                      // display the friend's details
        lbl_ListShowPhone_home.setText(temp.phone);
        lbl_ListShowEmail_home.setText(temp.email);
        show_index_home = friendList_home.getSelectionModel().getSelectedIndex();  // set the value of the index of the selected friend
        button_delete_home.setDisable(false);                           // Enable the delete button
    }
    public void deleteFriend_home(){
        /* Requires: An item/friend was selected in the list (show_index_home was set) and the disable button is enabled.
           Modifies: friendList
           Effects:  1) Removed the selected item from the friendList
                     2) Disable the delete button to prevent further deletion before another friend is selected
        */
        friendList_home.getItems().remove(show_index_home); // remove the item from the list
        lbl_ListShowName_home.setText("");                  // clear the friend's details in the labels
        lbl_ListShowPhone_home.setText("");
        lbl_ListShowEmail_home.setText("");
        button_delete_home.setDisable(true);                // disable the delete button
    }

    public void load_home() throws IOException  {
    /*  Requires: existence of the file
        Modifies: ListView friendList_home
        Effects: Read the friends details and store them in the friendList_home.
     */
        String str = text_group.getText();          // read group name
        Data list = new Data(str + ".txt");    // create an object for read and write to file
        list.friendList = friendList_home;           // copy the address of list friendList_home to the object
        list.read2lines();                           // read the data from file and save to the friendList_home
    }
    public void save_home()  throws IOException  {
        /*
        Effects: Save the friends detail from friendlist_home to a text file
         */
        String str = text_group.getText();       // read group name
        Data list = new Data(str + ".txt"); // create an object for read and write to file
        list.friendList = friendList_home;       // copy the address of list friendList_home to the object
        list.write2txt();                        // write the data to the file
    }



}