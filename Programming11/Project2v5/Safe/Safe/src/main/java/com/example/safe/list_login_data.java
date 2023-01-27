package com.example.safe;

import javafx.scene.control.ListView;
import java.io.*;

public class list_login_data {
    // this object is for storing login data on systems
    public String filename;                // filename for storing info
    public ListView<login> list = new ListView<login>();  // list storing all login info.

    // Constructor
    list_login_data(String input){
        this.filename = input;
    }

    public void read2list(String master) throws IOException {
        /*
        Requires: a correct password String master
        Modifies: this.list
        Effects:  Read encrypted data from file, decrypt using password, and store the info in the list
         */
        mixing rand = new mixing(master); // create the object rand which is used for encrypt and decrypt strings.

        list.getItems().clear();          // clear the list before reading
        FileReader fr = new FileReader(filename);    //declare the FileReader and BufferedReader
        BufferedReader br = new BufferedReader(fr);
        String line;                      // create the String variable line and read the info file to line
        while ((line = br.readLine()) != null){
            String company = line;    // this is the first line of the (encrypted) record
            String account = br.readLine();  // second line
            String password = br.readLine(); // third line
            String website = br.readLine();  // fourth line

            login temp = new login(rand.unmix(company), rand.unmix(account), rand.unmix(password), rand.unmix(website));
            //decrypt the four lines, and create the login object.
            list.getItems().add(temp);  // add the login item to the list
        }
        br.close();
        fr.close();
    }
    public void write2txt(String master) throws IOException {
        /*
        Requires: a correct password String master
        Effects:  Encrypt the list and store in file.
         */
        mixing rand = new mixing(master);  // create the object rand which is used for encrypt and decrypt strings.

        FileWriter fw = new FileWriter(filename);  //declare the FileReader and BufferedReader
        BufferedWriter bw = new BufferedWriter(fw);

        int listsize = list.getItems().size();   //  find the number of items in the list
        for (int i=0; i< listsize; i++) {
            login temp = list.getItems().get(i);          // for each item, get the item info and write it to files
            bw.write(rand.mix(temp.company) + "\r");
            bw.write(rand.mix(temp.account) + "\r");
            bw.write(rand.mix(temp.password) + "\r");
            bw.write(rand.mix(temp.website) + "\r");
        }
        bw.close();
        fw.close();
    }


}
