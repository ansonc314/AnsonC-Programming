package com.anson.module1.module1_4;
import com.anson.module1.globalvariables.Colour;
public class Circle extends TwoDShape {
    public final double PI=Math.PI;
    private double radius;

    /**
     * Constructor for Circle
     * @param radius
     * @param colour
     */
    Circle(double radius, Colour colour){
        this.radius = radius;
        this.setColour(colour);
    }

    /**
     * Compute the circle's area  Area = pi* radius^2
     * @return circle area
     */
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

    /**
     * Display circle's radius, colour and area
     * @return
     */
    public String toString(){
        return "This is a circle [Radius=" + this.radius + "], its colour is " + this.getColour()   + "\n";
    }
}