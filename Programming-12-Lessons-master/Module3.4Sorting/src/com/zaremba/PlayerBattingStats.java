package com.zaremba;

public class PlayerBattingStats {
    private double value1;
    private double value2;

    PlayerBattingStats(int v1, int v2){
        value1 = v1;
        value2 = v2;
    }

    public double getValue1(){
        return value1;
    }

    public double getValue2(){
        return value2;
    }

    public double getValue(int selector){
        double out = 0;
         switch (selector){
             case 1:
                 out = this.value1;
                 break;
             case 2:
                 out =  (double) this.value2;
                 break;
         }
        return out;
    }


}
