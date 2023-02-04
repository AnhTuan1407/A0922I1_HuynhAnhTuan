package furama_project.controllers;

import furama_project.services.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeManagement {
    public void employeeMenu() {
        int choice;
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("EMPLOYEE");
            System.out.println("1 Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    employeeService.display();
                    break;
                }

                case 2: {
                    employeeService.addNew();
                    break;
                }

                case 3: {
                    employeeService.edit();
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
