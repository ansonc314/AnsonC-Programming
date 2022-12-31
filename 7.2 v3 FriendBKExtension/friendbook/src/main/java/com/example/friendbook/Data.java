package com.example.friendbook;
import java.io.*;
import java.util.ArrayList;

public class Data {
    public String filename;
    public ArrayList<String> lines = new ArrayList<>();

    Data(String input){
        this.filename = input;
    }

    public void read2lines() throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            //System.out.println("Just read " + line);
            lines.add(line);
        }
        br.close();
    }

    public void write2txt() throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        //bw.write("Write to this file\r");
        for (String s: lines){
            bw.write(s + "\r");
        }
        bw.close();
    }


}
