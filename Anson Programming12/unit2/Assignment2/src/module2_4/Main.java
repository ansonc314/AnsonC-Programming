package module2_4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    /** Requires: the file exists
   Effects: Read each line in the file and return an arraylist of strings (one for each line)
    */

    public static void main(String[] args) throws IOException {

        String filename="illiad.txt";    // file to be searched in

        /**
         *
         * Read the file and Create a String line by concatenating all lines in the file.
         */

        FileReader fr = new FileReader(filename);    // construct FileReader and BufferedReader objects
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        String newLine;
        while ((newLine = br.readLine()) != null){
            line = line + " " + newLine;                         // read each line from file and add to the arraylist
        }
        br.close();

        Word illiad = new Word(line);
        illiad.FormatString();
        illiad.FormWordArray();

        System.out.println("The number of unique words inside the text is " + illiad.getWordSet().size());


    }
}
