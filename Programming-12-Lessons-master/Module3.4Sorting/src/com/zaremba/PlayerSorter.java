package com.zaremba;

import java.util.ArrayList;

public class PlayerSorter {

    public static ArrayList<PlayerBattingStats> mergeSort(ArrayList<PlayerBattingStats> playerList, int k ) {

        // Recursive control 'if' statement.
        if(playerList.size() <= 1) {

            return playerList;

        }

        int midpoint = playerList.size() / 2;

        // Declare and initialize left and right playerLists.
        ArrayList<PlayerBattingStats> left = new ArrayList<PlayerBattingStats>(playerList.subList(0,midpoint));
        ArrayList<PlayerBattingStats> right = new ArrayList<PlayerBattingStats>(playerList.subList(midpoint, playerList.size()));

        // Recursive call for left and right playerLists.
        left =  mergeSort(left,k);
        right =  mergeSort(right,k);



        // Get the merged left and right playerLists.
        ArrayList<PlayerBattingStats> result = merge(left, right, k);

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
