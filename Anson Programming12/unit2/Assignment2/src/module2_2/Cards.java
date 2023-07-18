package module2_2;

import java.util.Random;

public class Cards {

    private Suits suit;
    private int value;

    private boolean faceCard;

    /**
     * Default constructor (a random card will be generated)
     */
    public Cards(){
        Random rand = new Random();
        int int_random = rand.nextInt(13);
        this.value = int_random  + 1;

        int_random = rand.nextInt(4);

        switch (int_random) {
            case 0:
                this.suit =  Suits.SPADES;
                break;
            case 1:
                this.suit = Suits.HEARTS;
                break;
            case 2:
                this.suit = Suits.CLUBS;
                break;
            case 3:
                this.suit = Suits.DIAMONDS;
                break;
        }
        if (value>9){
            this.faceCard = true;
        }
        else {
            this.faceCard = false;
        }

    }

    /**
     * Constructor
     * @param int_index  integers 0, ... , 51
     *        Each integer corresponds to one of the cards
     * @return  a card with card index corresponding to the integer int_index
     */
    public Cards(int int_index){
        this.value = int_index%13  + 1;


        switch (int_index/13) {
            case 0:
                this.suit =  Suits.SPADES;
                break;
            case 1:
                this.suit = Suits.HEARTS;
                break;
            case 2:
                this.suit = Suits.CLUBS;
                break;
            case 3:
                this.suit = Suits.DIAMONDS;
                break;
        }
        if (value>9){
            this.faceCard = true;
        }
        else {
            this.faceCard = false;
        }
    }

    /**
     * Constructor
     * @param suit
     * @param value
     * @return  resulting a card with a given suit and value
     */
    public Cards(Suits suit, int value){
        this.suit = suit;
        this.value = value;
        if (value>9){
            this.faceCard = true;
        }
        else {
            this.faceCard = false;
        }
    }

    public String toString(){
        String temp;
        temp = "The card is of suit " + this.suit + ",  of value " + this.value;
        if (faceCard){
            temp = temp + "\nAnd it is a face card.\n";
        }
        else{
            temp = temp + "\nAnd it is NOT a face card.\n";
        }

        return temp;
    }
}