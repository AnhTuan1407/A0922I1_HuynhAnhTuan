package lesson12.java_collection_framework.product;

import java.util.Scanner;

public class Product {
    private String idProduct;
    private String nameProduct;
    private double price;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, double price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product " +
                "\t\t|| ID Product ||\t\t" + idProduct +
                "\t\t|| nameProduct ||\t\t" + nameProduct +
                "\t\t|| price ||\t\t" + price;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID Product: ");
        this.idProduct = scanner.nextLine();
        System.out.println("Enter Name Product: ");
        this.nameProduct = scanner.nextLine();
        System.out.println("Enter Price Product: ");
        this.price = scanner.nextDouble();
    }

    public void output() {
        System.out.println("ID Product: " + this.idProduct + "\t\t|| Name Product: " + this.nameProduct + "\t\t|| Price: " + price);
    }
}
