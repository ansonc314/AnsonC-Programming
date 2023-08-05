package module2_3;

import java.util.Comparator;

public class ComparatorByFace implements Comparator<Cards>  {

    /**
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return comparing the two objects o1 and o2 based on values
     */
    @Override
    public int compare(Cards o1, Cards o2) {

        if (o2.getFaceCard() &&  !o1.getFaceCard()){  // card 1 is face card and card 2 not
            return 1;
        }
        else {
            return -1;
        }


    }
}
