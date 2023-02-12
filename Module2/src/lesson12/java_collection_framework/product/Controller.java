package lesson12.java_collection_framework.product;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        ProductManager p = new ProductManager();
        do {
            System.out.println("1. Add new");
            System.out.println("2. Display");
            System.out.println("3. Search");
            System.out.println("4. Edit");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    p.addNew();
                    break;
                }

                case 2: {
                    p.display();
                    break;
                }

                case 3: {
                    p.search();
                    break;
                }

                case 4: {
                    p.edit();
                    break;
                }

                case 5: {
                    return;
                }
            }
        } while (true);

    }
}
