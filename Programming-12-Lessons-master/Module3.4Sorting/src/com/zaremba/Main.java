package com.zaremba;

public class Main {

    public static void main(String[] args) {
        /**
        int length = 100;
        int[] numbers = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 10000);
        }
        int[] numbers2 = new int[length];
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = (int)(Math.random() * 10000);
        }
        int[] numbers3 = new int[length];
        for (int i = 0; i < numbers3.length; i++) {
            numbers3[i] = (int)(Math.random() * 10000);
        }
        int[] numbers4 = new int[length];
        for (int i = 0; i < numbers4.length; i++) {
            numbers4[i] = (int)(Math.random() * 10000);
        }
        System.out.println("Starting Sorts");
        long start = System.nanoTime();
        numbers = Sorter.bubbleSort(numbers);
        numbers2 = Sorter.bubbleSort(numbers2);
        long end = System.nanoTime();
        System.out.println("Bubble: " + (end - start) / 1000000.00);
        start = System.nanoTime();
        numbers3 = Sorter.mergeSort(numbers3);
        numbers4 = Sorter.mergeSort(numbers4);
        end = System.nanoTime();
        System.out.println("Merge: " + (end - start) / 1000000.00);

        */
        //////////////////////////////////////////////////

        PlayerBattingStats[] left = new PlayerBattingStats[3];
        PlayerBattingStats[] right = new PlayerBattingStats[3];

        left[0] = new PlayerBattingStats(1,22);
        left[1] = new PlayerBattingStats(13,33);
        left[2] = new PlayerBattingStats(4,44);

        right[0] = new PlayerBattingStats(5,15);
        right[1] = new PlayerBattingStats(2,500);
        right[2] = new PlayerBattingStats(0,400);

        PlayerBattingStats[] all = new PlayerBattingStats[6];
        all[0] =  left[0];
        all[1] =  left[1];
        all[2] =  left[2];
        all[3] =  right[0];
        all[4] =  right[1];
        all[5] =  right[2];

        int k=2;
        PlayerBattingStats[] outputs = PlayerSorter.mergeSort(all,k);

        for (PlayerBattingStats o: outputs){
            System.out.println(o.getValue(1));
        }


    }


}
