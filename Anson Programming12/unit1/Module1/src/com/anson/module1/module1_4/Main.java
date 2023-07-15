package com.anson.module1.module1_4;

import com.anson.module1.globalvariables.Colour;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <TwoDShape> list = new ArrayList<TwoDShape>();
        list.add(new Triangle(3,5,4 , Colour.RED));
        list.add(new Circle(2, Colour.BLUE));
        list.add(new Circle(1, Colour.GREEN));
        list.add(new Triangle(12,5,13, Colour.BLUE));

        for (int ii = 0 ; ii<4 ; ii++){
            System.out.print(list.get(ii));
            System.out.println("Area is "+ list.get(ii).getArea() +"\n");
        }

        Triangle ww = new Triangle(3,5,6,Colour.BLUE);
        System.out.println(ww.getHeight());
        
    }
}