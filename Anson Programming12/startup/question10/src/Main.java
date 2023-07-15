
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        /*
            Effects: 1) Read 1 line from the file happyorsad.txt
                     2) Count how many happy or sad emoticon
                     3) compare the results
         */

        String hword = ":-)";
        String sword = ":-(";
        int word_length = 3;

        String filename = "happyorsad.txt";    // file to be searched in

        // Step 1: Read 1 line from the text
        FileReader fr = new FileReader(filename);    // construct FileReader and BufferedReader objects
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();  // read a line
        br.close();
        fr.close();


        // Step 2: Count and display the search result
        // 2.1 count number of happy faces
       int hword_count = 0;
        for (int pos=0; pos < line.length() - word_length + 1; pos++){
            String subword = line.substring(pos, pos+word_length);  // choose a substring from a given line
            if (subword.equals(hword)){   // if the search word is found:
                hword_count ++;    // increase total word count for whole text by 1
            }
        }

        // 2.2 count number of sad faces
        int sword_count = 0;
        for (int pos=0; pos < line.length() - word_length + 1; pos++) {
            String subword = line.substring(pos, pos + word_length);  // choose a substring from a given line
            if (subword.equals(sword)) {   // if the search word is found:
                sword_count++;    // increase total word count for whole text by 1
            }
        }

        System.out.print("Number of happy emoticons is ");
        System.out.println(hword_count);
        System.out.print("Number of sad emoticons is ");
        System.out.println(sword_count);


        if (hword_count == sword_count && hword_count==0 ){
            System.out.println("Result: none");
        }
        if (hword_count == sword_count && hword_count>0 ){
            System.out.println("Result: unsure");
        }
        if (hword_count > sword_count){
            System.out.println("Result: happy");
        }
        if (hword_count < sword_count){
            System.out.println("Result: sad");
        }

    }

}
