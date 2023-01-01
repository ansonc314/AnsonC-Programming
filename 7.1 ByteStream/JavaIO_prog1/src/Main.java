import javafx.scene.control.skin.SliderSkin;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> create_line_array(String filename) throws IOException {
        /* Requires: the file exists
           Effects: Read each line in the file and return an arraylist of strings (one for each line)
         */
        ArrayList<String> lines = new ArrayList<>(); // construct an arraylist object
        FileReader fr = new FileReader(filename);    // construct FileReader and BufferedReader objects
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            lines.add(line);                         // read each line from file and add to the arraylist
        }
        br.close();
        return lines;
    }
    public static void print_word_counts(String word, ArrayList<String> lines){
        /*
        Requires: an arraylist of strings, and a word to be searched
        Effects: count number of occurrences of the search word in each line, and in the whole file
         */
        int word_count=0;                           //initialize search word count for whole text
        int word_length = word.length();            //length of words to be searched
        int line_count = 1;                         // start searching from first line

        for (String s: lines){
            int word_count_in_line = 0;      // initialize word count for how many words in a given line
                // take a line from the list
                for (int pos=0; pos < s.length() - word_length + 1; pos++){
                    String subword = s.substring(pos, pos+word_length);  // choose a substring from a given line
                    if (subword.equals(word)){   // if the search word is found:
                       System.out.println("Word found in line " + line_count + ": at position " + (pos+1));
                       word_count ++;    // increase total word count for whole text by 1
                       word_count_in_line++;   // increase total word count for the line by 1
                    }
        } // end for loop
        System.out.println("Line " +  line_count + ": Total search word count is " + word_count_in_line +"\n"); // display search result for each line
        line_count++;  // increase line number
        }

        System.out.println("Total number of words in the whole file is equal to  " + word_count); // display total word counts in whole text
        return ;
    }
    public static void main(String[] args) throws IOException {
        /*
            Effects: 1) get input of a word to be searched
                     2) read a file to an arraylist
                     3) search for the occurrences of the search word and count the number of occurrences in each line and in the whole text
                     4) print out the search result
         */

        System.out.println("Enter the word to be searched");
        Scanner scanner = new Scanner(System.in);   // Create a Scanner obj for getting input
        String word = scanner.nextLine();
        String filename="ProgrammingHistory.txt";    // file to be searched in

        // Step 1: Create an arraylist lines to stores all the lines from the text
        ArrayList<String> lines = create_line_array(filename);

        // Step 2: Count and display the search result
        System.out.println("Displaying search results as below: \n");
        print_word_counts(word,lines);
    }
}

