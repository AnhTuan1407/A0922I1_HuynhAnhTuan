package furama_project.controllers;

import furama_project.services.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityManagement {
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    public void facilityMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("FACILITY");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    facilityService.display();
                    break;
                }

                case 2: {
                    facilityService.addNew();
                    break;
                }

                case 3: {
                    facilityService.displayFacilityMaintenance();
                    break;
                }

                case 4: {
                    return;
                }

                default: {
                    System.out.println("Wrong input! Retype!");
                    break;
                }
            }
        } while (true);
    }
}
