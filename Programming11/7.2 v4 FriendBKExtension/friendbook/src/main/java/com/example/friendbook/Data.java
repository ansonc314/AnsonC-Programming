package com.example.friendbook;
import javafx.scene.control.ListView;
import java.io.*;

public class Data {
    public String filename;
    public ListView<Friend> friendList = new ListView<Friend>();

    // Constructor using a given filename
    Data(String input){
        this.filename = input;
    }

    public void read2lines() throws IOException {
    /*
    Requires: friendList to be initialized and file exists
    Modifies: this.friendList
    Effects: info from a friend will be read from the file and be store in the friendList
     */

        friendList.getItems().clear();            // clear the current list
        FileReader fr = new FileReader(filename); // create FileReader and BufferedReader
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            String name = line;                     // Read friends' details from file
            String phone = br.readLine();
            String email = br.readLine();
            Friend temp = new Friend(name, phone, email);  // create a friend object and store to the list
            friendList.getItems().add(temp);
        }
        br.close();
    }
    public void write2txt() throws IOException {
        /*
        Requires: friendList to be initialized
        Effects: store the friendlist to file
         */
        FileWriter fw = new FileWriter(filename);    // create FileReader and BufferedReader
        BufferedWriter bw = new BufferedWriter(fw);

        int listsize = friendList.getItems().size();
        for (int i=0; i< listsize; i++) {
            Friend temp = friendList.getItems().get(i);     // read a friend object
            bw.write(temp.name + "\r");                  // write the friend's info on file
            bw.write(temp.phone + "\r");
            bw.write(temp.email + "\r");
        }
        bw.close();
    }


}
