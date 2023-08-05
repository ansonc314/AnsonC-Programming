package module2_4;

import java.util.HashSet;

public class Word {
    private HashSet<String> wordSet = new HashSet<>();
    private String line;

    /**
     * Default constructor
     */
    public Word(){
    }

    /**
     * Constructor
     * @param line -- it is a String
     */
    public Word(String line){
        this.line = line;
    }



    /**
     * @return  format the line String by a) turn all letters to lower case, b) turn all non-letter character to space
     */
    public void FormatString(){
        line = line.toLowerCase();

        for(int i=0 ; i<line.length() ; i++){
            int charASCII = (int) line.charAt(i);
            if (charASCII<97 || charASCII >122 ){
                if ( charASCII!=32 ){
                    line = line.substring(0,i) + " " + line.substring(i+1);
                }
            }
        }
    }

    /**
     *@return Split formatted string into wordArrays
     */
    public void FormWordArray(){
        String[] wordArray =  line.split(" ", 0);  // split the line using " " and store the words in the wordArray
        /**
         * Add words into set
         */
        for(String c:wordArray){
            if (c.length() > 0){
                wordSet.add(c);
            }
        }
    }

    public HashSet<String> getWordSet(){
        return wordSet;
    }


}
