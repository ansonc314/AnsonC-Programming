package com.example.safe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    int show_index;   // index of friend list for the friend being displayed

    @FXML     public TextField text_add_company, text_add_account, text_add_password, text_add_website;
    @FXML     public TextField text_show_company, text_show_account, text_show_password, text_show_website;
    @FXML     public ListView<login> list_login = new ListView<login>();
    @FXML     public login_list  display_list =  new login_list();


    public void add_login(){
        String company = text_add_company.getText();
        String account = text_add_account.getText();
        String password = text_add_password.getText();
        String website = text_add_website.getText();
        login temp = new login(company,account, password, website);
        list_login.getItems().add(temp);
        text_add_company.clear();
        text_add_account.clear();
        text_add_password.clear();
        text_add_website.clear();

    }
    public void display_login(){
        login temp;
        temp = list_login.getSelectionModel().getSelectedItem();
        text_show_company.setText(temp.company);
        text_show_account.setText(temp.account);
        text_show_password.setText(temp.password);
        text_show_website.setText(temp.website);
        show_index = list_login.getSelectionModel().getSelectedIndex();
    }
    public void delete_login(){
        list_login.getItems().remove(show_index);
        text_show_company.clear();
        text_show_account.clear();
        text_show_password.clear();
        text_show_website.clear();
    }

    public void generate_random_password(){
    text_add_password.setText("generate my pasword");
    }

}