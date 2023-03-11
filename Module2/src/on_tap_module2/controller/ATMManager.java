package on_tap_module2.controller;

import on_tap_module2.service.ATMService;

import java.util.Scanner;

public class ATMManager {
    public static void displayMainMenuATM() {
        ATMService atmService = new ATMService();
        do {
            System.out.println("1. Add new");
            System.out.println("2. Display");
            System.out.println("3. Remove");
            System.out.println("4. Search");
            System.out.println("5. Recharge");
            System.out.println("6. Transfer");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    atmService.addNew();
                    break;
                }

                case 2: {
                    atmService.display();
                    break;
                }

                case 3: {
                    atmService.remove();
                    break;
                }

                case 4: {
                    atmService.search();
                    break;
                }

                case 5: {

                    break;
                }

                case 6: {
                    atmService.transfer();
                    break;
                }

                case 7: {
                    return;
                }
            }
        } while (true);
    }
}
