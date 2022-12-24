package lesson7_abstract_class_interface.resizeable.colorable;

public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(String name, String color, double width, double length) {
        super(name, color);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double areaRectangle()
    {
        return this.length * this.width;
    }

    @Override
    public String toString() {
        return "Rectangle" +
                "\t|| Width: " + this.getWidth() +
                "\t|| Length: " + this.getLength() + "\t|| Area: " + this.areaRectangle();
    }
}
