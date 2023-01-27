package com.example.safe;

import java.util.Random;

public class Password {
    // this object is for storing password and for checking the validity of the password

    private String password;

    // constructor
    Password(String input){
        set_Password(input);
    }

    public void generate_random(){
        /*
        Modifies: this.password
        Effects: Generate a random string of length 10 with lower case letters and store it to this.password
         */
        Random random = new Random();   // create a Random object for generating random number
        String generatedString = "";
        for (int i=0; i<10; i++){
            char c = (char) random.nextInt(97, 122);   // generate a random number and convert it to a letter
            generatedString = generatedString + c;  // append the random char to the string.
        }
        this.password =  generatedString;
    }
    public boolean length_check(){
        /*
        Requires: String this.password
        Effects: Return false if the length is smaller than or equal to 7
         */
        boolean value = false;
        if (this.password.length()>7){
             value = true;
        }
        return value;
    }
    public void set_Password(String input){
        /* Requires: String input
           Modifies: this.password
           Effects:  Set this.password as input
         */
        this.password = input;
    }
    public String get_Password(){
        /*
           Effects:  return this.password
         */
        return this.password;
    }
    public boolean character_check(){
        /*
        Effects: Check if the password is made of lower case character or not
         */
        boolean value = true;  // initialize the value
        for (int i=0 ; i< this.password.length(); i++){
            char s = this.password.charAt(i);     // read every char, and set the value to false if inelgiible char is used.
            if ( (s>122)||(s<97)) {
                value = false;
                return value;
            }
        }
        return value;
    }

}
