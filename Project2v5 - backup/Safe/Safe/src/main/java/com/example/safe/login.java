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

    public String get_company() {
        /*
        Effects: return company name
         */
        return this.company;
    }
    public void set_company(String company){
        /*
        Requires: String company
        Modifies: this.company
        Effects: set company name
         */
        this.company= company;
    }
    public String get_account() {
        /*
        Effects: return account
         */
        return this.account;
    }
    public void set_account(String account) {
        /*
        Requires: String account
        Modifies: this.account
        Effects: set account
         */
        this.account= account ;
    }
    public String get_password() {
        /*
        Effects: return password
         */
        return this.password;
    }
    public void set_password(String password) {
        /*
        Requires: String password
        Modifies: this.password
        Effects: set password
         */
        this.password = password;
    }
    public String get_website() {
        /*
        Effects: return website
         */
        return this.website;
    }
    public void set_website(String website) {
        /*
        Requires: String website
        Modifies: this.website
        Effects: set website
         */
        this.website = website;
    }
    public String toString(){
        /*
        Effects: return company name
         */
        return this.company;
    }

}