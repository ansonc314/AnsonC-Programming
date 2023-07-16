package com.anson.module1.module1_4;
import com.anson.module1.globalvariables.Colour;

public abstract class TwoDShape {
    private double width,height;
    private Colour colour;

    /**
     * TwoDShape Constructor
     * @param width
     * @param height
     * @param colour
     */
        public TwoDShape(double width, double height, Colour colour){
            this.width = width;
            this.height = height;
            this.colour = colour;
        }

    /**
     * TwoDShape Constructor
     * @param colour
     */
        public TwoDShape(Colour colour){
            this.colour =colour;
        }

    /**
     * TwoDShape Default Constructor
     * set TwoDShape's colour to NONE by default.
     */
    public TwoDShape(){ this.colour =Colour.NONE; }


    /**
     * Abstract Method - implementation specified in the subclass
     * @return area of the shape.
     */
        public abstract double getArea();

        public void setHeight(double height){
            this.height=height;
        }
        public void setWidth(double width){
            this.width=width;
        }
        public void setColour(Colour colour){
        this.colour = colour;
    }

        public double getWidth(){
            return this.width;
        }
        public double getHeight(){
            return this.height;
        }
        public Colour getColour(){
            return this.colour;
        }

        public String toString(){
            String temp;
            temp = "TwoDShape: The width of this shape is " + Double.toString(this.width)
                    + " and the height is " + Double.toString(this.height);
            return temp;
        }

    }
