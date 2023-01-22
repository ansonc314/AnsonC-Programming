package com.example.safe;

import javafx.scene.control.*;
import java.io.IOException;
import java.lang.String;


public class Controller {

    public String passwd;
    int show_index_login, show_index_notes;   // index of selected items in list
    public TextField text_show_company, text_show_account, text_show_password, text_show_website;
    public TextField text_masterpassword;
    public ListView<login> list_login = new ListView<>();
    public ListView<notes> list_notes = new ListView<>();
    public TextArea tarea_notes, text_instruction;
    public TextField text_titles;
    public ChoiceBox cbox_choice;
    public Label lbl_message;
    public Button button_delete_login, button_delete_notes;
    public Button button_update_login, button_update_notes;
    public Button button_add_login, button_add_notes;


    public void new_login(){
        /*
        Effects: clear all text fields to enter login entries and reset buttons for adding new logins
         */
        text_show_company.clear();
        text_show_account.clear();
        text_show_password.clear();
        text_show_website.clear();
        button_delete_login.setDisable(true);
        button_update_login.setDisable(true);
        button_add_login.setDisable(false);

    }
    public void new_notes(){
        /*
        Effects: clear all text fields to enter notes entries and reset buttons for adding new notes
         */
        tarea_notes.clear();
        text_titles.clear();
        button_delete_notes.setDisable(true);
        button_update_notes.setDisable(true);
        button_add_notes.setDisable(false);
    }
    public void add_login() throws IOException {
        /*
        Requires: the login info was entered in to the text field
        Modifies: list_login
        Effects:  add the new item to the list_login and save to file
         */
        String company = text_show_company.getText();      // get login info from the corresponding text field
        String account = text_show_account.getText();
        String password = text_show_password.getText();
        String website = text_show_website.getText();
        login temp = new login(company,account, password, website);  // create a new login item
        list_login.getItems().add(temp);   // add the new item to  the login list
        text_show_company.clear();   // clear the text field for another input
        text_show_account.clear();
        text_show_password.clear();
        text_show_website.clear();

        button_delete_login.setDisable(true);   // update button status
        button_update_login.setDisable(true);
        button_add_login.setDisable(false);

        save_login();   // save the list to file
    }
    public void add_notes()  throws IOException {
        /*
        Requires: the notes info was entered in to the text field
        Modifies: list_notes
        Effects:  add the new item to list_notes and save to file
         */
        String title  = text_titles.getText();  // get notes info from the text field
        String notetext = tarea_notes.getText();
        notes temp = new notes(title,notetext);  // create a new note object
        list_notes.getItems().add(temp);  // add new note object to the note list
        tarea_notes.clear();                    // clear the text field for another input
        text_titles.clear();
        button_delete_notes.setDisable(true);   // update button status
        button_update_notes.setDisable(true);
        button_add_notes.setDisable(false);

        save_notes();   // save the list to the file
    }
    public void display_login(){
        /*
        Requires: an item in the list was selected and correct password entered
        Effects: display the item info in the corresponding text field
         */
        button_delete_login.setDisable(false);   // reset the button status
        button_update_login.setDisable(false);
        button_add_login.setDisable(true);

        login temp;             // create a login object to be display
        if (list_login.getItems().size() == 0){  // ensure the list is nonempty
            return;
        }

        temp = list_login.getSelectionModel().getSelectedItem();
        if (temp==null){  // ensure an item was selected
            return;
        }
        text_show_company.setText(temp.get_company());   // display the item info
        text_show_account.setText(temp.get_account());
        text_show_password.setText(temp.get_password());
        text_show_website.setText(temp.get_website());
        show_index_login = list_login.getSelectionModel().getSelectedIndex();   //retrieve the index of the selected item

    }
    public void display_notes(){
        /*
        Requires: an item in the list was selected and correct password entered
        Effects: display the item info in the corresponding text field
         */
        button_delete_notes.setDisable(false);   // reset the button status
        button_update_notes.setDisable(false);
        button_add_notes.setDisable(true);

        notes temp;     // create a note object to be displayed
        if (list_notes.getItems().size() == 0){ // ensure the list is nonempty
            return;
        }
        temp = list_notes.getSelectionModel().getSelectedItem();
        if (temp==null){     // ensure an item was selected
            return;
        }

        text_titles.setText(temp.get_title());       // display the item info
        tarea_notes.setText(temp.get_notetext());
        show_index_notes = list_notes.getSelectionModel().getSelectedIndex();   //retrieve the index of the selected item
    }
    public void update_login()  throws IOException {
        /*
        Requires: an item has been selected, the correct password is entered and info was entered
        Modifies: list_login
        Effects: update the item in the list
         */
        login temp;
        if (list_login.getItems().size() == 0){  // ensure the list is not empty
            return;
        }
        temp = list_login.getSelectionModel().getSelectedItem();
        if (temp==null){  // ensure an item was selected
            return;
        }

        temp.company = text_show_company.getText();   //update the list
        temp.account = text_show_account.getText();
        temp.password = text_show_password.getText();
        temp.website = text_show_website.getText();

        save_login();  // save the updated list
    }
    public void update_notes()  throws IOException  {
        /*
        Requires: an item has been selected, the correct password is entered and info was entered
        Modifies: list_notes
        Effects: update the item in the list
         */
        notes temp;
        if (list_notes.getItems().size() == 0){   // ensure the list is not empty
            return;
        }
        temp = list_notes.getSelectionModel().getSelectedItem();
        if (temp==null){     // ensure an item was selected
            return;
        }
        temp.title = text_titles.getText();    // update the list info
        temp.notetext = tarea_notes.getText();

        save_notes();   // save the list
    }
    public void delete_login()  throws IOException {
        /*
        Requires: an item has been selected
        Modifies: list_login
        Effects: Remove the selected item from the list and save to file
         */
        list_login.getItems().remove(show_index_login);   // remove selected item from list
        new_login();   // clear the text area and update button status
        save_login();  // save to file
    }
    public void delete_notes()  throws IOException {
        /*
        Requires: an item has been selected
        Modifies: list_notes
        Effects: Remove the selected item from the list and save to file
         */
        list_notes.getItems().remove(show_index_notes); // remove selected item from list
        new_notes();   // clear the text area and update button status
        save_notes();  // save to file
    }
    public void generate_random_password(){
        /*
        Effects: generate a random password and displayed into the password text field
         */
        Password passwd_obj = new Password("12345678");  // Create a password object
        passwd_obj.generate_random();                          // Generate a random password
        text_show_password.setText(passwd_obj.get_Password()); // Display the random password
    }
    public void showPasswd(){
        /*
        Effects: display the entered Master password
         */
        text_masterpassword.setText(passwd);
        }
    public void enterPasswd(){
        /*
        Requires: Master password entered in the textfield.
        Modifies: this.passwd
        Effects: If the password meets all critiera, enter to the system by setting this.passwd. If not, then display error message.
         */
        String temp;
        temp=text_masterpassword.getText();
        Password passwd_obj = new Password(temp);  // Create a password object using the enter password

        if (passwd_obj.length_check() && passwd_obj.character_check()){
            this.passwd=temp;           // update the passwd
            text_masterpassword.setText("********");  // hide the password
            lbl_message.setText("");    // disable warning message
        }
        else {
            lbl_message.setText("Password length must be at least 8 AND using SMALL letters"); // display error message
        }

    }
    public void load_login() throws IOException {
        /*
        Requires: file to be read exists, and correct password entered
        Modifies: list_login
        Effects:  Read file and decrypt stored login items and store them in the list_login list
         */
        String choice ;
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString();  // read the current group name
        String filename = choice + "_login.txt";  // derive the filename of the file to be read

        list_login_data obj_loginList = new list_login_data(filename);   // create the list_login_data object for read from file
        obj_loginList.list = list_login;   // pass by reference the list_login to the object
        obj_loginList.read2list(passwd);   // read from file, decrypt and store the login info to the list_login list

        text_show_company.setText("");      // clear the text field and reset the button
        text_show_account.setText("");
        text_show_password.setText("");
        text_show_website.setText("");
        button_update_login.setDisable(true);
        button_delete_login.setDisable(true);
        button_add_login.setDisable(false);

    }
    public void save_login()  throws IOException  {
        /*
        Effects: write the login list to file
         */
        String choice ;
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString(); // read the group name
        String filename = choice + "_login.txt";  // derive the filename of the file to be save
        list_login_data obj_loginList = new list_login_data(filename);  // create the list_login_data object to write into file
        obj_loginList.list = list_login; // pass by reference the list_login to the object
        obj_loginList.write2txt(passwd); // write the login list to the file
    }
    public void load_notes() throws IOException {
        /*
        Requires: file to be read exists, and correct password entered
        Modifies: list_notes
        Effects:  Read file and decrypt stored notes items and store them in the list_notes list
         */
        String choice ;
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString(); // read the current group name
        String filename = choice + "_notes.txt";  // derive the filename of the file to be read
        list_notes_data obj_notesList = new list_notes_data(filename);  // create the list_notes_data object to be read from file
        obj_notesList.list = list_notes;  // pass by reference the list_notes to the object
        obj_notesList.read2list(passwd);  // read from file to the list_notes

        text_titles.setText("");     // clear the text field and reset the button
        tarea_notes.setText("");
        button_update_notes.setDisable(true);
        button_delete_notes.setDisable(true);
        button_add_notes.setDisable(false);
    }
    public void load_login_switch()  {
        /*
        Modifies: list_login
        Effects: clear the list_login, after switching tab
*/
        list_login.getItems().clear();   // read from file, decrypt and store the login info to the list_login list

        text_show_company.setText("");      // clear the text field and reset the button
        text_show_account.setText("");
        text_show_password.setText("");
        text_show_website.setText("");
        button_update_login.setDisable(true);
        button_delete_login.setDisable(true);
        button_add_login.setDisable(false);

    }
    public void load_notes_switch()  {
        /*
        Modifies: list_notes
        Effects:  clear list_notes list after switching tab
         */
        list_notes.getItems().clear();
        text_titles.setText("");     // clear the text field and reset the button
        tarea_notes.setText("");
        button_update_notes.setDisable(true);
        button_delete_notes.setDisable(true);
        button_add_notes.setDisable(false);
    }
    public void save_notes()  throws IOException  {
        /*
        Effects: write the notes list to file
         */
        String choice ;
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString(); // read the group name
        String filename = choice + "_notes.txt"; // derive the filename of the file to be save
        list_notes_data obj_notesList = new list_notes_data(filename); // create the list_notes_data object to write into file
        obj_notesList.list = list_notes;  // pass by reference the list_login to the object
        obj_notesList.write2txt(passwd);  // write the notes list to the file
    }
    public void initialize() throws IOException {
        /*
        Effects:
        1) Display instructions on the TextArea tarea_instruction
        2) set default master passwd as "" and display prompt
        3) set button status
         */
        data instruction = new data ("instruction.txt");   // create a data object to read from file
        instruction.create_line_array();         // read lines and store in line array
        String str = instruction.read2string();  // convert line array into strings

        text_instruction.setText(str);   // set default master passwd and display prompt
        passwd  = "masterpassword";
        lbl_message.setText("Use \"masterpassword\" as default");

        button_delete_login.setDisable(true);   // set button status
        button_delete_notes.setDisable(true);
        button_update_login.setDisable(true);
        button_update_notes.setDisable(true);
    }


}