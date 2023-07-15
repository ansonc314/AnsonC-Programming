package com.anson.module1.module1_1;

public class Main {
    public static void main(String[] args) {

        TwoDShape z = new TwoDShape(5,10);
        System.out.println("TwoDShape z");
        System.out.println(z);

        Triangle a = new Triangle(3,4,5);
        System.out.println("\nTriangle a");
        System.out.println(a);


        Triangle b = new Triangle(35,3);
        System.out.println("\nTriangle b");
        System.out.println(b);

        System.out.println("\nTriangle c");
        TwoDShape c = new Triangle(3,4,5);
        System.out.println(c);

    }
}