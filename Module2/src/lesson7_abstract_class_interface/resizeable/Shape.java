package lesson7_abstract_class_interface.resizeable;

import java.util.Scanner;

public abstract class Shape implements Resizable {
    private String name;
    private String color;

    public Shape() {
    }

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter Color: ");
        this.color = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "SHAPE" +
                "\t|| Name: " + name +
                "\t|| Color: " + color;
    }

    public static void output(Shape[] shape) {
        for (Shape s : shape) {
            System.out.println(s.toString());
        }
    }

    @Override
    public void resize(double percent) {
    }
}
