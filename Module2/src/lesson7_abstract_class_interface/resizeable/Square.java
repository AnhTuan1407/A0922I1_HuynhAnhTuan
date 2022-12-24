package lesson7_abstract_class_interface.resizeable;

public class Square extends Shape {
    private double side;

    public Square() {
    }

    public Square(String name, String color, double side) {
        super(name, color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double areaSquare() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return "Square" +
                "\t|| Side: " + this.getSide() + "\t|| Area: " + areaSquare();
    }

    @Override
    public void resize(double percent) {
        this.side += this.side * (percent / 100);
    }
}
