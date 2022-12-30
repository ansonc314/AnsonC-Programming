import java.io.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<String> create_line_array(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>(); // array
        FileReader fr = new FileReader("in.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            lines.add(line);
        }
        br.close();
        return lines;
    }

    public static void print_word_counts(String word, ArrayList<String> lines){

        int word_count=0;
        int word_length = word.length();

        int line_count = 1; // start searching from first line

        for (String s: lines){
        int word_count_in_line = 0;
            // take a line from the list
            for (int pos=0; pos < s.length() - word_length + 1; pos++){
                String subword = s.substring(pos, pos+word_length);
                if (subword.equals(word)){
                   System.out.println("The word is found in line " + line_count + " and position " + (pos+1));
                   word_count ++;
                   word_count_in_line++;
                }

            } // end for loop
        System.out.println("Total number of words found in line " + line_count + " is equal to  " + word_count_in_line);
        line_count++;
        }

        System.out.println("Total number of words in the whole passage is equal to  " + word_count);

        return ;
    }

    public static void main(String[] args) throws IOException {

    String word = "abcd";  // words to be searched.

        // Step 1: Create an arraylist lines to stores all the lines from the text
        ArrayList<String> lines = create_line_array("in.txt");

        // Step 2: Count
        print_word_counts(word,lines);

    }
}



/*
    byte[] data = new byte[5];
    System.out.println("Prompt");
    System.in.read(data);
    for (byte b:data){
        System.out.println("Byte: " + b + "\tChar: " + (char) b);
    }
    FileInputStream in;
    FileOutputStream out;

    in = new FileInputStream("in.txt");
    out = new FileOutputStream("out.txt");

    int c;
     while((c = in.read()) != -1 ){
         out.write(c);
     }

    String addToFile = "\rAdding another line";


    ArrayList<String> lines = new ArrayList<>();
    FileReader fr = new FileReader("in.txt");
    BufferedReader br = new BufferedReader(fr);
    String line;
        while ((line = br.readLine()) != null){
                System.out.println("Just read " + line);
                lines.add(line);
                }
                br.close();

                for (String s: lines){
                System.out.println(s);
                }

                FileWriter fw = new FileWriter("out.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Write to this file\r");
                for (String s: lines){
                bw.write(s + "\r");
                }
                bw.close();
*/