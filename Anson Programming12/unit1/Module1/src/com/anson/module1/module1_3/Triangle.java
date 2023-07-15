package com.anson.module1.module1_3;

public class Triangle extends TwoDShape implements Rotate {
    private double side1, side2, side3;
    private double angle;

    public Triangle(double width, double height){
        super(width,height);  // by default, the triangle is a right-angled triangle with 2 sides width and height.
        this.side1 = width;
        this.side2 = height;
        this.side3 = Math.sqrt(Math.pow(width,2) + Math.pow(height,2));
        this.angle = 0;
    }
    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.angle = 0;
        setWidth(side1);  // the triangle's side 1 is always set to be the width
        setHeight(heronsHeight());
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

    public void setSides(double side1, double side2, double side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    public double getSide1(){
        return this.side1;
    }
    public double getSide2(){
        return this.side2;
    }
    public double getSide3(){
        return this.side3;
    }

    public String toString(){
        String temp;
        temp = "This Triangle has sides of length " + Double.toString(this.side1)
                + ", " + Double.toString(this.side2) + " and " + Double.toString(this.side3);
        temp = temp + "\nIts area is "  + Double.toString(this.getArea()) + ", its height is "  + Double.toString(getHeight())  + " and its rotation angle is "  + Double.toString(this.angle) + "\n";

        return temp;
    }

    public double getAngle(){
        return this.angle;
    }
    @Override
    public void rotate90() {
        this.angle = this.angle + 90;
    }

    @Override
    public void rotate180() {
        this.angle = this.angle + 180;
    }

    @Override
    public void rotate(double degree) {
        this.angle = this.angle + degree;
    }

}
