package module2_4;

import java.io.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args)  throws IOException {

        String line = ReadFile.Read2String("file.txt");

        /**
         * Create a Word object - which read the String line as input
         * Format the string by 1) turn all upper case letter to lower case ones, 2) convert all nonletter character to space
         * Then extract unit words and store them in a Set wordSet
         */
        Word illiad = new Word(line);
        illiad.FormatString();
        illiad.FormWordArray();

        System.out.println("The number of unique words inside the text is " + illiad.getWordSet().size());

    }
}
