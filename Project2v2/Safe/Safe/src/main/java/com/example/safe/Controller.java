package com.example.safe;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;


public class Controller {
    public String passwd;
    int show_index_login, show_index_notes;   // index of friend list for the friend being displayed
    public TextField text_show_company, text_show_account, text_show_password, text_show_website;
    public TextField text_masterpassword;
    public ListView<login> list_login = new ListView<login>();
    public ListView<notes> list_notes = new ListView<notes>();
    public TextArea tarea_notes;
    public TextField text_titles;


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
        passwd=text_masterpassword.getText();
        text_masterpassword.setText("********");
    }

    public void load_login() throws IOException {
        list_login_data obj_loginList = new list_login_data("login.txt");
        obj_loginList.list = list_login;
        obj_loginList.read2list();
    }

    public void save_login()  throws IOException  {
        list_login_data obj_loginList = new list_login_data("login.txt");
        obj_loginList.list = list_login;
        obj_loginList.write2txt();
    }

}