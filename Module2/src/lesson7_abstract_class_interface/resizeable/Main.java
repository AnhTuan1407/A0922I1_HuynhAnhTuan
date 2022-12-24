package lesson7_abstract_class_interface.resizeable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("Circle1", "Red", 5);
        shapes[1] = new Rectangle("Rectangle1", "Blue", 4, 10);
        shapes[2] = new Square("Square1", "Yellow", 4);
        Shape.output(shapes);
//        for (Shape s : shapes){
//            System.out.println(s);
//        }

        for (Shape a : shapes) {
            a.resize(Math.random() * 1000);
        }

        System.out.println("\n");
        System.out.println("RESIZABLE");
        Shape.output(shapes);
    }
}
