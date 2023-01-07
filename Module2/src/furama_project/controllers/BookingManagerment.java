package furama_project.controllers;

import java.util.Scanner;
public class BookingManagerment {
    public void bookingMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("BOOKING");
            System.out.println("1 Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
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

                    break;
                }

                case 5: {

                    break;
                }

                case 6: {
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
