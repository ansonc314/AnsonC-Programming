package module2_3;

import java.util.ArrayList;
import java.util.Collections;
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

        /**
         * Each integer corresponds to one of the cards in a deck.
         * Iterate over the list or integers in the list, and add the card (corresponding to the integer)
         * to the cardList
         * @ return: cardList is a list with 52 random cards
         */
        LinkedList<Cards> cardList = new LinkedList<Cards>();  // Create a linkedList
        Iterator<Integer> iterator_deck_int = deck_int.iterator();
        while(iterator_deck_int.hasNext()){
            cardList.add(new Cards(iterator_deck_int.next()));
        }


        /**
         * Create a list drawCardList for the first 10 cards in the list cardList
         */
        LinkedList<Cards> drawCardList = new LinkedList<Cards>();  // Create a linkedList for storing drawn cards
        Cards drawCard;
        for (int i=0; i<10 ; i++){
            drawCard  = cardList.removeFirst();
            drawCardList.add(drawCard);
        }


        System.out.println("*********** BEFORE SORTING");
        for (Cards c : drawCardList){
            System.out.println(c);
        }

        System.out.println("*********** SORTED by Suits");
        ComparatorBySuits compareBySuits = new ComparatorBySuits();
        Collections.sort(drawCardList, compareBySuits);
        for (Cards c : drawCardList){
            System.out.println(c);
        }

        System.out.println("*********** SORTED by Values");
        ComparatorByValues  compareByValues = new ComparatorByValues();
        Collections.sort(drawCardList, compareByValues);
        for (Cards c : drawCardList){
            System.out.println(c);
        }

    }
}
