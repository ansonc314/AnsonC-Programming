package com.example.safe;
import java.util.ArrayList;
import java.io.*;

public class data {
    public String filename;
    public ArrayList<String> lines = new ArrayList<>();
    data(String input) {
        this.filename = input;
    }

    public ArrayList<String> create_line_array() throws IOException {
        /* Requires: the file exists
           Effects: Read each line in the file and return an arraylist of strings (one for each line)
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
    String tmp ="";
    for (String s: this.lines){
        tmp = tmp+s+"\n";
    }
    return tmp;
}
}