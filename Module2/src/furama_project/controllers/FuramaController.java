package furama_project.controllers;

import java.util.Scanner;

public class FuramaController {
    public void displayMainMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("MAIN MENU");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    EmployeeManagement employeeManagement = new EmployeeManagement();
                    employeeManagement.employeeMenu();
                    break;
                }

                case 2: {
                    CustomerManagement customerManagement = new CustomerManagement();
                    customerManagement.customersMenu();
                    break;
                }

                case 3: {
                    FacilityManagement facilityManagement = new FacilityManagement();
                    facilityManagement.facilityMenu();
                    break;
                }

                case 4: {
                    BookingManagerment bookingManagerment = new BookingManagerment();
                    bookingManagerment.bookingMenu();
                    break;
                }

                case 5: {
                    PromotionManagement promotionManagement = new PromotionManagement();
                    promotionManagement.promotionMenu();
                    break;
                }

                case 6: {
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Wrong input! Retype!");
                    break;
                }
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
