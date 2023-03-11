package on_tap_module2.controller;

import on_tap_module2.service.ATMService;
import on_tap_module2.service.CreditService;

import java.util.Scanner;

public class CreditManager {
    public static void displayMainMenuCredit() {
        CreditService creditService = new CreditService();
        do {
            System.out.println("1. Add new");
            System.out.println("2. Display");
            System.out.println("3. Remove");
            System.out.println("4. Search");
            System.out.println("5. Recharge");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    creditService.addNew();
                    break;
                }

                case 2: {
                    creditService.display();
                    break;
                }

                case 3: {
                    creditService.remove();
                    break;
                }

                case 4: {
                    creditService.search();
                    break;
                }

                case 5: {

                    break;
                }

                case 6: {
                    return;
                }
            }
        } while (true);
    }
}
