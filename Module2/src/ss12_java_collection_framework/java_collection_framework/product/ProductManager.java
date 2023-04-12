package lesson12.java_collection_framework.product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();

    public void addNew() {
        Product product = new Product();
        product.input();
        products.add(product);
    }

    public void edit() {
        System.out.println("Enetr ID you want to search: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        int check = 0;
        for (Product p : products) {
            if (p.getIdProduct().equals(id)) {
                p.output();
                check = 1;
                System.out.println("1. Edit Name Product");
                System.out.println("2. Edit Price Product");
                System.out.println("3. Exit");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: {
                        System.out.println("Enter new name product: ");
                        String newName = scanner.nextLine();
                        p.setNameProduct(newName);
                        System.out.println("Successful change");
                        p.output();
                        break;
                    }

                    case 2: {
                        System.out.println("Enter new price product: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        p.setPrice(newPrice);
                        System.out.println("Successful change");
                        p.output();
                        break;
                    }

                    case 3: {
                        return;
                    }
                }
            }
        }
        if (check == 0) {
            System.out.println("NOT FOUND!");
        }

    }

    public void display() {
        for (Product p : products) {
            p.output();
        }
    }

    public void search() {
        System.out.println("Enetr ID you want to search: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        int check = 0;
        for (Product p : products) {
            if (p.getIdProduct().equals(id)) {
                p.output();
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("NOT FOUND!");
        }
    }
}
