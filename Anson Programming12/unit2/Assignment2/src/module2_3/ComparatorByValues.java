package module2_3;

import java.util.Comparator;

public class ComparatorByValues  implements Comparator<Cards>  {

    /**
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return comparing the two objects o1 and o2 based on values
     */
    @Override
    public int compare(Cards o1, Cards o2) {

        if (o1.getValue()  > o2.getValue()){
            return 1;
        }
        else if (o1.getValue()  < o2.getValue()){
            return -1;
        }
        return 0;

    }
}
