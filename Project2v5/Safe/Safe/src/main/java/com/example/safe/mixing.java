package com.example.safe;

public class mixing {
    // This object is used for encrypt and decrypt strings using a password as key

    public String passwd;  // string password
    private int passwd_int;// integer key derived from password

// constructor
    mixing(String passwd){
        /*
        Requires: String password
        Modifies: this.passwd, this.passwd_int
        Effects: Store the provided passwd, generate an integer key this_passwd_int from the password.
         */
        this.passwd = passwd;    // set password
        int tmp = 0;             // create an integer key from password
        for (int i=0; i<passwd.length(); i++){
            tmp = tmp + passwd.charAt(i);
        }
        this.passwd_int = tmp;
    }


    public String mix(String str){
        /*
        Requires: String str - to be encrypted
        Effects:  Encrypt the str using the key this.passwd_int. Return the encrypted string
         */
        String convertedStr=""; // initialize
        for (int i = 0; i < str.length(); i++) {
            // read a character, convert to ascii value and add a random number and evaluate the encrypted char.
            int newasciiValue;
            char convertedChar;
            int asciiValue = str.charAt(i);   //changes ascii values into characters
            newasciiValue = asciiValue + 1 + ((this.passwd_int + i*i)%15); // encrypt the original ascii values
            convertedChar = (char) (newasciiValue); // find the encrypted char for the encrypted ascii value
            convertedStr = convertedStr + convertedChar;  // append encrypted char to string convertedStr
        }
        return convertedStr;
    }

    public String unmix(String str){
        /*
        Requires: String str - to be decrypted
        Effects:  Decrypt the str using the key this.passwd_int. Return the decrypted string
         */
        String convertedStr="";
        for (int i = 0; i < str.length(); i++) {
            // read a character, convert to ascii value and delete a random number and evaluate the encrypted char.
            int newasciiValue;
            char convertedChar;
            int asciiValue = str.charAt(i); //changes ascii values into characters
            newasciiValue = asciiValue - 1 - ((this.passwd_int + i*i)%15); // decrypt the original ascii values
            convertedChar = (char) (newasciiValue); // find the char for the original ascii value
            convertedStr = convertedStr + convertedChar; // append decrypted char to string convertedStr
        }
        return convertedStr;
    }

}
