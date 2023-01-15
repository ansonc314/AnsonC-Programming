package com.example.safe;

import java.util.Random;
import java.lang.Iterable;

public class Password {
    public String password;

    Password(String input){
        set_Password(input);
    }

    public void generate_random_password(){
        Random random = new Random();
        String generatedString = "";
        for (int i=0; i<10; i++){
            char c = (char) random.nextInt(97, 122);
            generatedString = generatedString + c;
        }
        this.password =  generatedString;
    }

    public boolean length_check(){
        boolean value = false;
        if (this.password.length()>7){
             value = true;
        }
        return value;
    }

    public String get_Password(){
        return this.password;
    }

    public void set_Password(String input){
        this.password = input;
    }

    public boolean character_check(){

        boolean value = true;
        for (int i=0 ; i< this.password.length(); i++){
            char s = this.password.charAt(i);

            int tmp = (int) s;
            if ( (tmp>122)||(tmp<97)) {
                value = false;
            }
        }
        return value;
    }

}
