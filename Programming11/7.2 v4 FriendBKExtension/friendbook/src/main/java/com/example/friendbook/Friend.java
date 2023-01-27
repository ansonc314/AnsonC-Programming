package com.example.friendbook;

public class Friend {
    public String name;  // Full Name
    public String phone; // Phone
    public String email; // Email Address

    // Constructor
    Friend(String Name, String Phone, String email) {
        setName(Name);
        setPhone(Phone);
        setEmail(email);
    }

    // getters and setters
    public String getName() {
    // Effects: return name
        return this.name;
    }
    public void setName(String Name){
    // Requires: String Name
    // Modifies: this.name
    // Effects: set name
        this.name= Name;
    }
    public String getPhone() {
        // Effects: return phone number
        return this.phone;
    }
    public void setPhone(String Phone) {
        // Requires: String Phone
        // Modifies: this.phone
        // Effects: set phone number
        this.phone= Phone ;
    }
    public String getEmail() {
        // Effects: return email address
        return this.email;
    }
    public void setEmail(String emailName) {
        // Requires: String emailName
        // Modifies: this.email
        // Effects: set this.email
        this.email=emailName;
    }
    public String toString(){
    /*
    Effects: Return the object's name
     */
        return this.name;
    }

}