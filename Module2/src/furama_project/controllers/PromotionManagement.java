package furama_project.controllers;

import java.util.Scanner;

public class PromotionManagement {
    public void promotionMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("PROMOTION");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {

                    break;
                }

                case 2: {

                    break;
                }

                case 3: {
                    FuramaController furamaController = new FuramaController();
                    furamaController.displayMainMenu();
                    break;
                }

                default: {
                    System.out.println("Wrong input! Retype!");
                    break;
                }
            }
        } while (true);
    }
}
