package com.anson.module1.module1_3;
public class Circle extends TwoDShape {
    public final double PI=Math.PI;
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return Math.pow(this.radius,2)*this.PI;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public String toString(){
        return "This is a circle [Radius=" + this.radius + "] and its area is " + Double.toString(getArea())   + "\n";


    }
}