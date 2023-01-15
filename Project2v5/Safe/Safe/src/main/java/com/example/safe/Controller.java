package com.example.safe;

import javafx.scene.control.*;
import java.io.IOException;
import java.util.Random;


public class Controller {
//    public Password master_password;
    public String passwd = "";
    int show_index_login, show_index_notes;   // index of friend list for the friend being displayed
    public TextField text_show_company, text_show_account, text_show_password, text_show_website;
    public TextField text_masterpassword;
    public ListView<login> list_login = new ListView<login>();
    public ListView<notes> list_notes = new ListView<notes>();
    public TextArea tarea_notes, text_instruction;
    public TextField text_titles;
    public ChoiceBox cbox_choice;
    public Label lbl_message;
    public Button button_delete_login, button_delete_notes;
    public Button button_update_login, button_update_notes;
    public Button button_add_login, button_add_notes;


    public void new_login(){
        text_show_company.clear();
        text_show_account.clear();
        text_show_password.clear();
        text_show_website.clear();
        button_delete_login.setDisable(true);
        button_update_login.setDisable(true);
        button_add_login.setDisable(false);

    }
    public void new_notes(){
        tarea_notes.clear();
        text_titles.clear();
        button_delete_notes.setDisable(true);
        button_update_notes.setDisable(true);
        button_add_notes.setDisable(false);
    }
    public void add_login() throws IOException {
        String company = text_show_company.getText();
        String account = text_show_account.getText();
        String password = text_show_password.getText();
        String website = text_show_website.getText();
        login temp = new login(company,account, password, website);
        list_login.getItems().add(temp);
        text_show_company.clear();
        text_show_account.clear();
        text_show_password.clear();
        text_show_website.clear();

        button_delete_login.setDisable(true);
        button_update_login.setDisable(true);

        save_login();
    }
    public void add_notes()  throws IOException {
        String title  = text_titles.getText();
        String notetext = tarea_notes.getText();
        notes temp = new notes(title,notetext);
        list_notes.getItems().add(temp);
        new_notes();

        save_notes();
    }
    public void display_login(){
        button_delete_login.setDisable(false);
        button_update_login.setDisable(false);
        button_add_login.setDisable(false);
        login temp;
        if (list_login.getItems().size() == 0){
            return;
        }

        temp = list_login.getSelectionModel().getSelectedItem();
        if (temp==null){
            return;
        }
        text_show_company.setText(temp.company);
        text_show_account.setText(temp.account);
        text_show_password.setText(temp.password);
        text_show_website.setText(temp.website);
        show_index_login = list_login.getSelectionModel().getSelectedIndex();

        button_add_login.setDisable(true);
    }
    public void display_notes(){
        button_delete_notes.setDisable(false);
        button_update_notes.setDisable(false);
        button_add_notes.setDisable(false);
        notes temp;
        if (list_notes.getItems().size() == 0){
            return;
        }
        temp = list_notes.getSelectionModel().getSelectedItem();
        if (temp==null){
            return;
        }

        text_titles.setText(temp.title);
        tarea_notes.setText(temp.notetext);
        show_index_notes = list_notes.getSelectionModel().getSelectedIndex();

        button_add_notes.setDisable(true);
    }

    public void update_login()  throws IOException {
        login temp;
        if (list_login.getItems().size() == 0){
            return;
        }
        temp = list_login.getSelectionModel().getSelectedItem();
        temp.company = text_show_company.getText();
        temp.account = text_show_account.getText();
        temp.password = text_show_password.getText();
        temp.website = text_show_website.getText();

        save_login();
    }
    public void update_notes()  throws IOException  {
        notes temp;
        if (list_notes.getItems().size() == 0){
            return;
        }
        temp = list_notes.getSelectionModel().getSelectedItem();
        temp.title = text_titles.getText();
        temp.notetext = tarea_notes.getText();

        save_notes();
    }

    public void delete_login(){
        list_login.getItems().remove(show_index_login);
        new_login();
    }
    public void delete_notes(){
        list_notes.getItems().remove(show_index_notes);
        new_notes();
    }

    public void generate_random_password(){
        Random random = new Random();
        String generatedString = "";
        for (int i=0; i<10; i++){
            char c = (char) random.nextInt(97, 122);
            generatedString = generatedString + c;
        }
        text_show_password.setText(generatedString);
    }

    public void showPasswd(){
    text_masterpassword.setText(passwd);
    }
    public void enterPasswd(){
        String temp;
        temp=text_masterpassword.getText();
        Password passwd_obj = new Password(temp);

        if (passwd_obj.length_check() && passwd_obj.character_check()){
            passwd=temp;
            text_masterpassword.setText("********");
            lbl_message.setText("");
        }
        else {lbl_message.setText("Password length must be at least 8 AND using SMALL letters"); }

    }

    public void load_login() throws IOException {
        String choice ="";
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString();
        String filename = choice + "_login.txt";
        list_login_data obj_loginList = new list_login_data(filename);
        obj_loginList.list = list_login;
        obj_loginList.read2list(passwd);

        text_show_company.setText("");
        text_show_account.setText("");
        text_show_password.setText("");
        text_show_website.setText("");
        button_update_login.setDisable(true);
        button_delete_login.setDisable(true);

    }

    public void save_login()  throws IOException  {
        String choice ="";
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString();
        String filename = choice + "_login.txt";
        list_login_data obj_loginList = new list_login_data(filename);
        obj_loginList.list = list_login;
        obj_loginList.write2txt(passwd);
    }


    public void load_notes() throws IOException {
        String choice ="";
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString();
        String filename = choice + "_notes.txt";
        list_notes_data obj_notesList = new list_notes_data(filename);
        obj_notesList.list = list_notes;
        obj_notesList.read2list(passwd);

        text_titles.setText("");
        tarea_notes.setText("");

        button_update_notes.setDisable(true);
        button_delete_notes.setDisable(true);
        button_add_notes.setDisable(false);
    }

    public void save_notes()  throws IOException  {
        String choice ="";
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString();
        String filename = choice + "_notes.txt";
        list_notes_data obj_notesList = new list_notes_data(filename);        obj_notesList.list = list_notes;
        obj_notesList.write2txt(passwd);
    }



    public void initialize() throws IOException {
        /* Effects: Display instructions on the TextArea tarea_instruction
         */
        data instruction = new data ("instruction.txt");
        instruction.create_line_array();
        String str = instruction.read2string();
        text_instruction.setText(str);
        passwd = "masterpassword";

        button_delete_login.setDisable(true);
        button_delete_notes.setDisable(true);
        button_update_login.setDisable(true);
        button_update_notes.setDisable(true);
    }


}