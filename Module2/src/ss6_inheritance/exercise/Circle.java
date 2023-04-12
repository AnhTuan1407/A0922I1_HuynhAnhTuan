package lesson6_inheritance;

public class Circle {
    private double radius;
    private String color;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double areaCircle() {
        return radius * radius * 3.14;
    }

    public String toString() {
        return "Circle " + "\t\t|| Radius: " + this.getRadius() + "\t\t|| Color: " + this.getColor();
    }

    public static class Cylinder extends Circle {
        private double height;

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public Cylinder() {
        }

        public Cylinder(double radius, String color, double height) {
            super(radius, color);
            this.height = height;
        }

        public double areaCylinder() {
            return 2 * 3.14 * this.getRadius() * (this.getRadius() + height);
        }

        public double volumeCylinder() {
            return super.areaCircle() * this.height;
        }

        @Override
        public String toString() {
            return super.toString() + "\t\t|| Cylinder " +
                    "\t\t || Height: " + height;
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5, "Red");
        Cylinder cylinder = new Cylinder(5, "Yellow", 6);

        System.out.println(circle + "\t\t|| Area:  " + circle.areaCircle());
        System.out.println(cylinder + "\t\t|| Area:  " + cylinder.areaCylinder() + "\t\t|| Volume: " + cylinder.volumeCylinder());
    }
}


