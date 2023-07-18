package module2_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {


        /**
        * Read the file and Create a String line by concatenating all lines in the file.
        * @param  : Read the lines from the file ("filename") and concatenate to a string
        */
         public static String Read2String(String filename)  throws IOException  {

             FileReader fr = new FileReader(filename);    // construct FileReader and BufferedReader objects
             BufferedReader br = new BufferedReader(fr);

             String line = "";
             String newLine;
             while ((newLine = br.readLine()) != null){
                 line = line + " " + newLine;                         // read each line from file and add to the arraylist
             }
             br.close();

             return line;
         }


    /**
     * Read the file and Create a String ArrayList, each item in the list is a line in the file.
     *
     */
        public static ArrayList<String> Read2StringArray(String filename)  throws IOException  {
            ArrayList<String> lineArray = new ArrayList<>();

            FileReader fr = new FileReader(filename);    // construct FileReader and BufferedReader objects
            BufferedReader br = new BufferedReader(fr);

            String newLine;
            while ((newLine = br.readLine()) != null){
                lineArray.add(newLine) ;     // add each line to the String Array
            }
            br.close();

            return lineArray;
        }

}
