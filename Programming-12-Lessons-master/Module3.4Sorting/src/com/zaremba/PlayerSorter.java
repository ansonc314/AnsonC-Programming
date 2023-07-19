package com.zaremba;

public class PlayerSorter {

    public static PlayerBattingStats[] mergeSort(PlayerBattingStats[] array, int k ) {

        // Recursive control 'if' statement.
        if(array.length <= 1) {

            return array;

        }

        int midpoint = array.length / 2;

        // Declare and initialize left and right arrays.
        PlayerBattingStats[] left = new PlayerBattingStats[midpoint];
        PlayerBattingStats[] right = new PlayerBattingStats[array.length - midpoint];

        System.arraycopy(array, 0, left, 0, midpoint);
        System.arraycopy(array,midpoint,right,0, array.length - midpoint);


        PlayerBattingStats[] result = new PlayerBattingStats[array.length];

        // Recursive call for left and right arrays.
               left =  mergeSort(left,k);
               right =  mergeSort(right,k);

        // Get the merged left and right arrays.
         result = merge(left, right, k);

        // Return the sorted merged array.
        return result;

    }



    /**
     *  Merging  sorted list
     * @param left
     * @param right
     * @return
     */
    // Merges the left and right array in ascending order.
    public static PlayerBattingStats[] merge(PlayerBattingStats[] left, PlayerBattingStats[] right, int k) {

        // Merged result array.
        PlayerBattingStats[] result = new PlayerBattingStats[left.length + right.length];

        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        // While there are items in either array...
        while(leftPointer < left.length || rightPointer < right.length) {

            // If there are items in BOTH arrays...
            if(leftPointer < left.length && rightPointer < right.length) {

                // If left item is less than right item...
                if(left[leftPointer].getValue(k) < right[rightPointer].getValue(k)) {

                    result[resultPointer++] = left[leftPointer++];

                } else {

                    result[resultPointer++] = right[rightPointer++];

                }

            }

            // If there are only items in the left array...
            else if(leftPointer < left.length) {

                result[resultPointer++] = left[leftPointer++];

            }

            // If there are only items in the right array...
            else if(rightPointer < right.length) {

                result[resultPointer++] = right[rightPointer++];

            }

        }

        return result;

    }





}
