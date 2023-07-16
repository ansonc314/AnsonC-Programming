package com.anson.module1.module1_3;

public abstract class TwoDShape {
    private double width,height;

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }
    public TwoDShape(){
    }
    public abstract double getArea();

    public void setHeight(double inputHeight){
        this.height=inputHeight;
    }
    public void setWidth(double inputWidth){
        this.width=inputWidth;
    }
    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }

    public String toString(){
        String temp;
        temp = "TwoDShape: The width of this shape is " + Double.toString(this.width)
                + " and the height is " + Double.toString(this.height);
        return temp;
    }

}