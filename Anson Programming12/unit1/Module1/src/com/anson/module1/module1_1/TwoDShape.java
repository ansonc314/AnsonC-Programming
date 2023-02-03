package com.anson.module1.module1_1;

public class TwoDShape {
    double width,height;

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }
    public TwoDShape(){
    }
    public double getArea(){
        return this.height*this.width;
    }
    public void setHeight(double height){
        this.height = height ;
    }
}
