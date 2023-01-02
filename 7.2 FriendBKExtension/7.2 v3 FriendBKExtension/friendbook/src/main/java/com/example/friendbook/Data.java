package com.example.friendbook;
import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;

public class Data {
    public String filename;
    public ListView<Friend> friendList = new ListView<Friend>();
    // public ArrayList<String> lines = new ArrayList<>();

    Data(String input){
        this.filename = input;
    }

    /*
    public void set_lines(ArrayList<String> input){
        this.lines = input;
    }
*/

    public void read2lines() throws IOException {
        friendList.getItems().clear();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            String name = line;
            String phone = br.readLine();
            String email = br.readLine();
            Friend temp = new Friend(name, phone, email);
            friendList.getItems().add(temp);
        }
        br.close();
    }


    public void write2txt() throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);

        int listsize = friendList.getItems().size();
        for (int i=0; i< listsize; i++) {
            Friend temp = friendList.getItems().get(i);
            bw.write(temp.name + "\r");
            bw.write(temp.phone + "\r");
            bw.write(temp.email + "\r");
        }
        bw.close();
    }


}
