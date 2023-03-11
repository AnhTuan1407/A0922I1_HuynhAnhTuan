package on_tap_module2.controller;

import java.util.Scanner;

import static on_tap_module2.controller.ATMManager.displayMainMenuATM;
import static on_tap_module2.controller.CreditManager.displayMainMenuCredit;

public class Controller {
    public static void displayMainMenu() {
        do {
            System.out.println("1. ATM Card");
            System.out.println("2. Credit Card");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    displayMainMenuATM();
                    break;
                }

                case 2: {
                    displayMainMenuCredit();
                    break;
                }

                case 3: {

                    return;
                }
            }
        } while (true);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
