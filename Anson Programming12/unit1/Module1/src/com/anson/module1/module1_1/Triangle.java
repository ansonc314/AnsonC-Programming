package com.anson.module1.module1_1;

public class Triangle extends TwoDShape{
    private double side1, side2, side3;

    public Triangle(double width, double height){
        super(width,height);
    }

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.width = heronsHeight();
        this.height = side1;
    }


    /**
     * Computer Area of triangle using Heron formula
     * https://en.wikipedia.org/wiki/Heron%27s_formula
     * @return area of triangle
     */
    @Override
    public double getArea(){
        double s = (this.side1+ this.side2+ this.side3)/2;
        double area = Math.sqrt((s*(s-this.side1)*(s-this.side2)*(s-this.side3)));
        return area;
    }

    /**
     * Computer height of triangle using Herons formula
     * https://en.wikipedia.org/wiki/Heron%27s_formula
     * @return height
     */
    private double heronsHeight(){
        // height with respect to side1
        return 2*getArea()/side1;
    }

}
