package com.example.safe;

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
        // Modifies: this
        // Effects: set name
        this.name= Name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String Phone) {
        this.phone= Phone ;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String emailName) {
        this.email=emailName;
    }

    public String toString(){
        return this.name;
    }

}