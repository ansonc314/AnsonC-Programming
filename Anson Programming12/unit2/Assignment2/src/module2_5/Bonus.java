package module2_5;

import module2_4.ReadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) throws IOException {
        /**
         * e.g. if the ciphertext is bcepnfo.
         * then we check if key = 1, the plaintext is abdomen
         * The word is in the dictionary and so we declare the decryption is successful
         */

        ArrayList<String> dictionary = ReadFile.Read2StringArray("words_alpha.txt");   // read the file to string array list

        System.out.println( "Enter the encrypted word\n" );  // Ask for the ciphertext word
        Scanner scanner = new Scanner( System.in );
        String cipherWord = scanner.nextLine();

        Cipher cipher = new Cipher(0);   // create the object for decryption
        for (int i=0; i<26; i++){
            cipher.resetKey(i);   // set the key to i
            String decryptString = cipher.decryptString(cipherWord);   // decrypt the word
            if (dictionary.contains(decryptString)){    // if the decrypted word is in the words_alpha.txt, then we find the decrypted word
                System.out.println("The key is found and is equal to "  + i);
                System.out.println("The decrypted word is  "  + cipher.decryptString(cipherWord));

            }
        }


    }

}
