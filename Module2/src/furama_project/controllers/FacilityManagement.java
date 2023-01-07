package furama_project.controllers;

import java.util.Scanner;

public class FacilityManagement {
    public void facilityMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("FACILITY");
            System.out.println("1 Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
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

                    break;
                }

                case 4: {
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
