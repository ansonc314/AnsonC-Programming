package com.example.database;

import javafx.beans.property.SimpleStringProperty;

public class SimpleStringRecord {
    public SimpleStringProperty UserName;
    public SimpleStringProperty Password;
    public SimpleStringProperty FullName;


    public SimpleStringRecord(String UserName, String Password, String FullName) {
        this.UserName =new SimpleStringProperty(UserName);
        this.Password = new SimpleStringProperty(Password);
        this.FullName = new SimpleStringProperty(FullName);
    }

    public String getUserName() {
        return UserName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return UserName;
    }

    public String getPassword() {
        return Password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return Password;
    }

    public String getFullName() {
        return FullName.get();
    }

    public SimpleStringProperty fullNameProperty() {
        return FullName;
    }
}
