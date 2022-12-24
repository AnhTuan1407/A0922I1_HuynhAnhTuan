package lesson7_abstract_class_interface.resizeable.colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle("Circle1", "Yellow", 5);
        shapes[1] = new Rectangle("Rectangle1", "Blue", 5, 10);
        shapes[2] = new Square("Square1", "Black", 2);
        shapes[3] = new Circle("Circle2", "Red", 3);
        shapes[4] = new Square("Square2", "White", 7);

        for (Shape s : shapes) {
            System.out.print(s);
            if (s instanceof Colorable) {
                s.howToColor();
            }
            System.out.println("");
        }
    }
}
