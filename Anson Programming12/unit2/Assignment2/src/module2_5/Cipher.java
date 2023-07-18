package module2_5;

public class Cipher {

    /**
     *
     * @param key  = 0, ... 25
     * @param plainText - only lower case letters will be encrypted
     * @return cipherText - lower case letter will be shifted for key position.
     */
    public static String encrypt(int key, String plainText){

        String cipherText= plainText;
        int len = plainText.length();

        for(int i=0 ; i<plainText.length() ; i++) {
            int charASCII = (int) plainText.charAt(i);
            if (charASCII > 96 && charASCII < 123) {
                charASCII = charASCII - 97;
                charASCII = ((charASCII + key) % 26) + 97;
                cipherText = cipherText.substring(0,i) + ((char) charASCII) + cipherText.substring(i+1);
            }
        }
        return cipherText;
    }

    /**
     *
     * @param key  = 0, ... 25
     * @param cipherText - only lower case letters will be decrypted
     * @return cipherText - lower case letter will be back-shifted for key position.
     */
    public static String decrypt(int key, String cipherText){

        String plainText= cipherText;
        int len = plainText.length();

        for(int i=0 ; i<cipherText.length() ; i++) {
            int charASCII = (int) cipherText.charAt(i);
            if (charASCII > 96 && charASCII < 123) {
                charASCII = charASCII - 97;
                charASCII = ((charASCII - key+26) % 26) + 97;
                plainText = plainText.substring(0,i) + ((char) charASCII) + plainText.substring(i+1);
            }
        }
        return plainText;
    }



}
