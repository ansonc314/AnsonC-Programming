package com.example.safe;

import java.util.Scanner;

public class mixing {
    public String passwd;
    public int passwd_int;

    mixing(String passwd){
        this.passwd = passwd;
        int tmp = 0;
        for (int i=0; i<passwd.length(); i++){
            tmp = tmp + passwd.charAt(i);
        }
        this.passwd_int = tmp;
    }

    public String mix(String str){
        int tmp = this.passwd_int;

        char convertedChar;
        String convertedStr="";
        int newasciiValue;

        for (int i = 0; i < str.length(); i++) {
            int asciiValue = str.charAt(i);
            newasciiValue = asciiValue + 1 + ((tmp + i*i)%15);
            convertedChar = (char) (newasciiValue);
            convertedStr = convertedStr + convertedChar;
        }
        return convertedStr;
    }

    public String unmix(String str){
        int tmp = this.passwd_int;

        char convertedChar;
        String convertedStr="";
        int newasciiValue;
        for (int i = 0; i < str.length(); i++) {
            int asciiValue = str.charAt(i); //changes ascii values into characters
            newasciiValue = asciiValue - 1 - ((tmp + i*i)%15); // decrypt the original ascii values
            convertedChar = (char) (newasciiValue); // find the char for the original ascii value
            convertedStr = convertedStr + convertedChar; // concatenate to form the original message
        }
        return convertedStr;
    }

}
