package module2_3;

import java.util.Comparator;

public class ComparatorBySuits implements Comparator<Cards> {

    /**
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return comparing the two objects o1 and o2 based on suit
     */
    @Override
    public int compare(Cards o1, Cards o2) {
        int suit_index1 = 0;
        int suit_index2 = 0;
        // map suits to index for comparisons
        switch (o1.getSuit()){
            case SPADES:   suit_index1 = 0;
                            break;
            case HEARTS:   suit_index1 = 1;
                            break;
            case CLUBS:   suit_index1 = 2;
                             break;
            case DIAMONDS:   suit_index1 = 3;
                            break;
        }

        switch (o2.getSuit()){
            case SPADES:   suit_index2 = 0;
                break;
            case HEARTS:   suit_index2 = 1;
                break;
            case CLUBS:   suit_index2 = 2;
                break;
            case DIAMONDS:   suit_index2 = 3;
                break;
        }


        if (suit_index1 > suit_index2){
            return 1;
        }
        else if (suit_index1 < suit_index2){
            return -1;
        }

        return 0;
    }

}
