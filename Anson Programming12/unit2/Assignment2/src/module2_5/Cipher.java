package module2_5;

import java.util.HashMap;

public class Cipher {

    /**
     * encrypt describes the encryption mapping. For example, when constructed with the key k=1,
     * the mapping is a->b, b->c ,.... z->a
     */
    private HashMap<String, String> encrypt = new HashMap<String, String>();
    private HashMap<String, String> decrypt = new HashMap<String, String>();
    int key;


    /**
     * Constructor
     * @param key is used to create the Hashmap encrypt and decrypt
     */
    public Cipher(int key){
        this.key = key;
        /*
          Construct the encrypt map
          e.g., if the key = 1, the map is "a" -> "b", ... "z"->"a"
         */
        for (int letterIdx = 0; letterIdx <26 ; letterIdx++   ){
            char plainTextChar = ((char) (letterIdx + 97)  );
            char cipherTextChar = (char) (((letterIdx + key) % 26) + 97);
            encrypt.put(Character.toString(plainTextChar), Character.toString(cipherTextChar));
        }

        /*
        Construct the decrypt map
                  e.g., if the key = 1, the map is "b" -> "a", ... "a"->"z"
         */
        for (int letterIdx = 0; letterIdx <26 ; letterIdx++   ){
            char plainTextChar = ((char) (letterIdx + 97)  );
            char cipherTextChar = (char) (((letterIdx + 26 - key) % 26) + 97);
            decrypt.put(Character.toString(plainTextChar), Character.toString(cipherTextChar));
        }


    }

    public void resetKey(int k){
        this.key = k;
        /*
          Construct the encrypt map
          e.g., if the key = 1, the map is "a" -> "b", ... "z"->"a"
         */
        for (int letterIdx = 0; letterIdx <26 ; letterIdx++   ){
            char plainTextChar = ((char) (letterIdx + 97)  );
            char cipherTextChar = (char) (((letterIdx + key) % 26) + 97);
            encrypt.put(Character.toString(plainTextChar), Character.toString(cipherTextChar));
        }

        /*
        Construct the decrypt map
                  e.g., if the key = 1, the map is "b" -> "a", ... "a"->"z"
         */
        for (int letterIdx = 0; letterIdx <26 ; letterIdx++   ){
            char plainTextChar = ((char) (letterIdx + 97)  );
            char cipherTextChar = (char) (((letterIdx + 26 - key) % 26) + 97);
            decrypt.put(Character.toString(plainTextChar), Character.toString(cipherTextChar));
        }

    }



        /**
         *
         * @param plainText - only lower case letters will be encrypted
         * @return cipherText - lower case letter will be shifted for key positions.
         */
    public String encryptString(String plainText){
        String cipherText= "";
        for(int i=0 ; i<plainText.length() ; i++) {
            int charASCII = (int) plainText.charAt(i);
            if (charASCII > 96 && charASCII < 123) {   // check if the char at position i is a letter or not
                cipherText = cipherText + encrypt.get(plainText.substring(i,i+1));  // encrypt the character and attach to the cipherText
                }
            else {
                cipherText = cipherText  + plainText.charAt(i);   // if the char is not a letter, no encryption is needed
                 }
            }
        return cipherText;
    }

    /**
     * @param cipherText - only lower case letters will be decrypted
     * @return plainText - lower case letter will be back shifted for key positions.
     */
    public String decryptString(String cipherText){

        String plainText= "";

        for(int i=0 ; i<cipherText.length() ; i++) {
            int charASCII = (int) cipherText.charAt(i);
            if (charASCII > 96 && charASCII < 123) {    // check if the char at position i is a letter or not
                plainText = plainText + decrypt.get(cipherText.substring(i,i+1)); // decrypt the character and attach to the plainText
            }
            else {
                plainText = plainText  + cipherText.charAt(i);   // if the char is not a letter, no decryption is needed
            }
        }
        return plainText;
    }

    @Override
    public String toString() {
        return "This is an en/decryption system with a key k = " + key;
    }
}
