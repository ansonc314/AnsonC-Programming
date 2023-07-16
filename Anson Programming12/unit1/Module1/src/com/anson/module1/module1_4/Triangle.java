package com.anson.module1.module1_4;

import com.anson.module1.globalvariables.Colour;

public class Triangle extends TwoDShape implements Rotate {
    private double side1, side2, side3;
    private double angle;

    public Triangle(double width, double height, Colour colour){
        super(width,height,colour);  // by default, the triangle is a right-angled triangle with 2 sides width and height.
        this.side1 = width;
        this.side2 = height;
        this.side3 = Math.sqrt(Math.pow(width,2) + Math.pow(height,2));
        this.angle = 0;
        this.setColour(colour);
    }
    public Triangle(double side1, double side2, double side3, Colour colour){
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.angle = 0;
        this.setColour(colour);
        setWidth(side1);  // the triangle's side 1 is always set to be the width
        setHeight(heronsHeight());
    }


    /**
     * Computer Area of triangle using Heron formula
     * see https://en.wikipedia.org/wiki/Heron%27s_formula
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
    public double heronsHeight(){
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

    /**
     * Return Properties of Triangles: the lengths of 3 sides, colour, rotation angle and area
     * @return side1,side2,side3, angle and colour
     */
    public String toString(){
        String temp;
        temp = "This Triangle has sides of length " + Double.toString(this.side1)
                + ", " + Double.toString(this.side2) + " and " + Double.toString(this.side3);
        temp = temp +    ", its colour is "  + this.getColour()   + " and its rotation angle is "  + Double.toString(this.angle) + "\n";

        return temp;
    }

    public double getAngle(){
        return this.angle;
    }

    /**
     * Rotate the angle of the triangle by 90 degree
     * @return increment the angle variable by 90 degree
     */
    @Override
    public void rotate90() {
        this.angle = this.angle + 90;
    }

    /**
     * Rotate the angle of the triangle by 180 degree
     * @return increment the angle variable by 180 degree
     */
    @Override
    public void rotate180() {
        this.angle = this.angle + 180;
    }

    /**
     * Rotate the angle of the triangle
     * @param degree - the input of the degrees to be rotated
     * @return increment the angle variable by the amount of the input degree
     */
    @Override
    public void rotate(double degree) {
        this.angle = this.angle + degree;
    }

}
