package furama_project.controllers;

import furama_project.services.CustomerService;
import furama_project.services.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerManagement {
    public void customersMenu() {
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("CUSTOMER");
            System.out.println("1 Display list customers");
            System.out.println("2. Add new customers");
            System.out.println("3. Edit customers");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    customerServiceImpl.display();
                    break;
                }

                case 2: {
                    customerServiceImpl.addNew();
                    break;
                }

                case 3: {
                    customerServiceImpl.edit();
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
