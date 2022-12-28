package com.example.safe;

public class login {
    public String company;  // Full Name
    public String account; // Account Name
    public String password; // Password
    public String website; // webSite


    // Constructor
    login(String company, String account, String password, String website) {
        set_company(company);
        set_account(account);
        set_password(password);
        set_website(website);
    }

    // getters and setters
    public String get_company() {
        // Effects: return name
        return this.company;
    }
    public void set_company(String company){
        // Requires: String Name
        // Modifies: this
        // Effects: set name
        this.company= company;
    }

    public String get_account() {
        return this.account;
    }

    public void set_account(String account) {
        this.account= account ;
    }

    public String get_password() {
        return this.password;
    }

    public void set_password(String password) {
        this.password = password;
    }

    public String get_website() {
        return this.website;
    }

    public void set_website(String website) {
        this.website = website;
    }

    public String toString(){
        return this.company;
    }

}