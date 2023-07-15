package com.anson.module1.module1_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <TwoDShape> list = new ArrayList<TwoDShape>();
        list.add(new Triangle(3,5,4));
        list.add(new Circle(2));
        list.add(new Circle(1));
        list.add(new Triangle(12,5,13));

        for (int ii = 0 ; ii<4 ; ii++){
            System.out.println(list.get(ii));
        }


        System.out.println("Now, test the rotate interface/n");
        Triangle d = (Triangle) list.get(0);
        System.out.println("inital angle = " + d.getAngle());
        d.rotate90();   // rotate 90 degree
        d.rotate180();  // rotate another 180 degree
        d.rotate(50);  // rotate another 50 degree. So totally rotate for 320 degree
        System.out.println("after rotation is "+d.getAngle());



    }
}