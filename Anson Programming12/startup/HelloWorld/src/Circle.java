

public class Circle{
    private double radius = 1.0;

    public  Circle(){this.radius = 1.0;}
    public  Circle(double r){setRadius(r);  }
    public double getRadius(){ return this.radius;}
    public void setRadius(double r){this.radius = r;}
    public double getArea(){ return this.radius*this.radius * Math.PI;}
    public double getCircumference(){ return 2*this.radius * Math.PI;}
    public String toString(){return "Circle[radius=" + Double.toString(radius) + "]";}

}