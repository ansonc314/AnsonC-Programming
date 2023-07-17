package module2_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


import static java.util.Collections.shuffle;

public class Main {
    public static void main(String[] args) {

        /**
         * Generate a random permutation of integers 0,1, ... 51
         */
        ArrayList<Integer> deck_int = new ArrayList<Integer>();
        for (int i = 0; i <= 51; i++) {   // Create a list of integers 0, 1, ... 51
            deck_int.add(i);
        }
        shuffle(deck_int);  // shuffle the list

        LinkedList<Cards> cardList = new LinkedList<Cards>();  // Create a linkedList

        /**
         * Each integer corresponds to one of the cards in a deck.
         * Iterate over the list or integers in the list, and add the card (corresponding to the integer)
         * to the cardList
         * @ return: cardList is a list with 52 random cards
         */
        Iterator<Integer> iterator_deck_int = deck_int.iterator();
        while(iterator_deck_int.hasNext()){
            cardList.add(new Cards(iterator_deck_int.next()));
        }


        /**
         * Create a list drawCardList for the first 7 cards in the list cardList
         */
        LinkedList<Cards> drawCardList = new LinkedList<Cards>();  // Create a linkedList
        Cards drawCard;
        for (int i=0; i<7 ; i++){
            drawCard  = cardList.removeFirst();
            drawCardList.add(drawCard);
        }


        Iterator<Cards> iterator_drawCardList = drawCardList.iterator();
        while (iterator_drawCardList.hasNext()){
            System.out.println(iterator_drawCardList.next());
        }


    }
}
