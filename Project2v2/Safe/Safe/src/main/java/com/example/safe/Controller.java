package com.example.safe;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    int show_index_login;   // index of friend list for the friend being displayed
    public TextField text_show_company, text_show_account, text_show_password, text_show_website;
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
    public void delete_login(){
        list_login.getItems().remove(show_index_login);
        new_login();
    }

    public void generate_random_password(){
    text_show_password.setText("generate my pasword");
    }

}