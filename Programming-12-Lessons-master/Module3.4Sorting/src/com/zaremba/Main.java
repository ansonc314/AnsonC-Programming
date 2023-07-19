package com.zaremba;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        ArrayList<PlayerBattingStats> left = new ArrayList<PlayerBattingStats>();
        ArrayList<PlayerBattingStats> right = new ArrayList<PlayerBattingStats>();
        ArrayList<PlayerBattingStats> all = new ArrayList<PlayerBattingStats>();

        left.add(new PlayerBattingStats(1,22));
        left.add(new PlayerBattingStats(4,33));
        left.add(new PlayerBattingStats(13,44));

        right.add(new PlayerBattingStats(0,15));
        right.add(new PlayerBattingStats(2,400));
        right.add(new PlayerBattingStats(20,500));

        all.addAll(left);
        all.addAll(right);

        ArrayList<PlayerBattingStats> test = new ArrayList<PlayerBattingStats>();
//      test = PlayerSorter.merge(left,right,2) ;
        test = PlayerSorter.mergeSort(all , 1);

        for (PlayerBattingStats o: test){
            System.out.println(o.getValue(2));
        }

        /**




        ArrayList<PlayerBattingStats> test = new ArrayList<PlayerBattingStats>(all.subList(0,2));



        int k=2;
//       PlayerBattingStats[] outputs = PlayerSorter.mergeSort(all,k);

        for (PlayerBattingStats o: all){
            System.out.println(o.getValue(2));
        }


        for (PlayerBattingStats o: test){
            System.out.println(o.getValue(2));
        }

            */
    }


}
