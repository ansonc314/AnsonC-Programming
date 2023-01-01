package com.example.safe;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;


public class Controller {
    public String passwd = "default master password";
    int show_index_login, show_index_notes;   // index of friend list for the friend being displayed
    public TextField text_show_company, text_show_account, text_show_password, text_show_website;
    public TextField text_masterpassword;
    public ListView<login> list_login = new ListView<login>();
    public ListView<notes> list_notes = new ListView<notes>();
    public TextArea tarea_notes, text_instruction;
    public TextField text_titles;
    public ChoiceBox cbox_choice;
    public Label lbl_message;

    public void new_login(){
        text_show_company.clear();
        text_show_account.clear();
        text_show_password.clear();
        text_show_website.clear();
    }
    public void new_notes(){
        tarea_notes.clear();
        text_titles.clear();
    }
    public void add_login(){
        String company = text_show_company.getText();
        String account = text_show_account.getText();
        String password = text_show_password.getText();
        String website = text_show_website.getText();
        login temp = new login(company,account, password, website);
        list_login.getItems().add(temp);
        new_login();

    }
    public void add_notes(){
        String title  = text_titles.getText();
        String notetext = tarea_notes.getText();
        notes temp = new notes(title,notetext);
        list_notes.getItems().add(temp);
        new_notes();
    }
    public void display_login(){
        login temp;
        temp = list_login.getSelectionModel().getSelectedItem();
        text_show_company.setText(temp.company);
        text_show_account.setText(temp.account);
        text_show_password.setText(temp.password);
        text_show_website.setText(temp.website);
        show_index_login = list_login.getSelectionModel().getSelectedIndex();
    }
    public void display_notes(){
        notes temp;
        temp = list_notes.getSelectionModel().getSelectedItem();
        text_titles.setText(temp.title);
        tarea_notes.setText(temp.notetext);
        show_index_notes = list_notes.getSelectionModel().getSelectedIndex();
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
        if (temp.length()>7){
            passwd=temp;
            text_masterpassword.setText("********");
            lbl_message.setText("");
        }
        else {lbl_message.setText("Password length must be at least 8"); }

    }

    public void load_login() throws IOException {
        String choice ="";
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString();
        String filename = choice + "_login.txt";
        list_login_data obj_loginList = new list_login_data(filename);
        obj_loginList.list = list_login;
        obj_loginList.read2list(passwd);
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
    }

    public void save_notes()  throws IOException  {
        String choice ="";
        choice = cbox_choice.getSelectionModel().getSelectedItem().toString();
        String filename = choice + "_notes.txt";
        list_notes_data obj_notesList = new list_notes_data(filename);        obj_notesList.list = list_notes;
        obj_notesList.write2txt(passwd);
    }



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
        text_instruction.setText(str);
    }


}