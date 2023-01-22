package com.example.safe;
import java.util.ArrayList;
import java.io.*;

public class data {
    // this object is used when loading instructions to the program

    public String filename;           // file name storing the data
    public ArrayList<String> lines = new ArrayList<>();   // array list storing lines from the file

    // Constructor
    data(String input) {
        this.filename = input;
    }

    public ArrayList<String> create_line_array() throws IOException {
        /*
        Requires: the file exists
        Modifies: ArrayList lines
        Effects: Read each line from the file and return an arraylist of strings (one for each line)
         */
        FileReader fr = new FileReader(this.filename);    // construct FileReader and BufferedReader objects
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            lines.add(line);                         // read each line from file and add to the arraylist
        }
        br.close();
        return lines;
    }
    public String read2string(){
    /*
    Requires: String Array List this.lines
    Effects: read the line array lines and converted to a string
     */
        String tmp ="";                       // initialize the string
        for (String s: this.lines){
            tmp = tmp+s+"\n";                 // read a line and append to the string tmp
        }
        return tmp;
    }
}