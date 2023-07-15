package com.anson.module1.module1_2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <TwoDShape> list = new ArrayList<>();
        list.add(new Triangle(3,5,4));
        list.add(new Circle(2));
        list.add(new Circle(1));
        list.add(new Triangle(12,5,13));

       for (int ii = 0 ; ii<4 ; ii++){
           System.out.println(list.get(ii));
       }

    }
}