package module2_5;

import module2_4.ReadFile;

import java.io.IOException;
import java.util.ArrayList;

public class Bonus {
    public static void main(String[] args) throws IOException {
        Cipher cipher = new Cipher(0);
        ArrayList<String> line = ReadFile.Read2StringArray("words_alpha.txt");   // read the file to string array list
        ArrayList<String> decryptLine = new ArrayList<>();   // declare a string array for storing decrypted words

        String filenamePrefix = "trial";  // the decrypted file will be store in a filename "trial" + x where x is the key
       for (int i=0; i<26; i++){
           decryptLine.clear();
           String filename = filenamePrefix + i;
           cipher.resetKey(i);   // set the key to i
                for(String s: line){
                    String decryptString = cipher.decryptString(s);
                    decryptLine.add(decryptString);
                }
            Write2File.write2txt(filename,decryptLine);
       }
    }

}
