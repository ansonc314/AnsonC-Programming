package module3_4Sorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that takes in an ArrayList and sorts the players by various criteria
 * using a mergesort.
 */

public class PlayerSorter {
    //The following fields are the different sort types:
    public static int GAMESPLAYED = 0;
    public static int ATBATS = 1;
    public static int RUNS = 2;
    public static int PERCENTRUNS = 3; // Calculated by: runs/atBats
    public static int PERCENTONBASE = 4; // Calculated by (hits + doubles + triples) / atBats

    /**
     * This method is an interface that allows the sorting of a player given based on
     * certain criteria.  There are 5 options to sort a player which are by Games played,
     * at bats, runs, percent runs, percent on base.
     * The sort is in descending order (Largest to smallest)
     * This method calls one of 5 private methods that will do the sort based on the chosen criteria.
     * @param playerList List of players containing the statistics
     * @param sortType How the user wants the players sorted.  The value should be chosed from one of
     *                 the 5 static fields from the class.
     * @return An ArrayList that is sorted according to the users specification.
     */
    // public static ArrayList<PlayerBattingStats> sort(ArrayList<PlayerBattingStats> list, int sortType) {
        public static ArrayList<PlayerBattingStats> sort(ArrayList<PlayerBattingStats> playerList, int sortType ) {

            // Recursive control 'if' statement.
            if(playerList.size() <= 1) {

                return playerList;

            }

            int midpoint = playerList.size() / 2;

            // Declare and initialize left and right playerLists.
            ArrayList<PlayerBattingStats> left = new ArrayList<PlayerBattingStats>(playerList.subList(0,midpoint));
            ArrayList<PlayerBattingStats> right = new ArrayList<PlayerBattingStats>(playerList.subList(midpoint, playerList.size()));

            // Recursive call for left and right playerLists.
               left =  sort(left,sortType);
               right = sort(right,sortType);



            // Get the merged left and right playerLists.
            ArrayList<PlayerBattingStats> result =  merge(left, right, sortType);

            // Return the sorted merged playerList.
            return result;

        }




















        /**
         *  Merging  sorted list
         * @param left
         * @param right
         * @return
         */
        // Merges the left and right playerList in ascending order.
        public static ArrayList<PlayerBattingStats> merge(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right, int k) {

            // Merged result playerList.
            ArrayList<PlayerBattingStats> result = new ArrayList<PlayerBattingStats>();

            // Declare and initialize pointers for all playerLists.
            int leftPointer, rightPointer, resultPointer;
            leftPointer = rightPointer = resultPointer = 0;

            // While there are items in either playerList...
            while(leftPointer < left.size() || rightPointer < right.size()) {

                // If there are items in BOTH playerLists...
                if(leftPointer < left.size() && rightPointer < right.size()) {

                    // If left item is less than right item...
                    if(left.get(leftPointer).getValue(k) < right.get(rightPointer).getValue(k)) {

                        result.add(left.get(leftPointer));
                        leftPointer++;

                    } else {

                        result.add(right.get(rightPointer));
                        rightPointer++;
                    }

                }

                // If there are only items in the left playerList...
                else if(leftPointer < left.size()) {

                    result.add(left.get(leftPointer));
                    leftPointer++;
                }

                // If there are only items in the right playerList...
                else if(rightPointer < right.size()) {

                    result.add(right.get(rightPointer));
                    rightPointer++;

                }

            }

            return result;

        }


}
