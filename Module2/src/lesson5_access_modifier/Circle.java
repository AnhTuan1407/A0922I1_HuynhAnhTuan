package lesson5_access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double areaCircle() {
        return this.radius * this.radius * 3.14;
    }

    @Override
    public String toString() {
        return "Circle" + "\t|| Color: " + this.color +
                "\t|| Radius: " + this.getRadius() + "\t|| Area: " + areaCircle();
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
    }
}
