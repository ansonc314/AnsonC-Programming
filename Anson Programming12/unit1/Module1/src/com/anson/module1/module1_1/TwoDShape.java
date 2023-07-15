package com.anson.module1.module1_1;

public class TwoDShape {
    private double width,height;

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }
    public TwoDShape(){ }
    public double getArea(){
        return this.height*this.width;
    }

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
        temp = "TwoDShapes: The width of this shape is " + Double.toString(this.width)
                   + " and the height is " + Double.toString(this.height);
        return temp;
    }

}
