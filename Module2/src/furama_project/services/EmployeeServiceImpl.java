package furama_project.services;

import furama_project.controllers.EmployeeManagement;
import furama_project.models.Employee;
import furama_project.type.Level;
import furama_project.type.Position;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public void addNew() {
        Employee employee = new Employee();
        employee.input();
        employees.add(employee);
    }

    @Override
    public void display() {
        for (Employee e : employees) {
            e.output();
        }
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        for (Employee e : employees) {
            e.output();
        }
        do {
            System.out.println("Enter ID you want to change information: ");
            String id = scanner.nextLine();

            for (Employee e : employees) {
                if (e.getIdPerson().equals(id)) {
                    e.output();
                    System.out.println("1. Name");
                    System.out.println("2. Date of Birth");
                    System.out.println("3. Sex");
                    System.out.println("4. Identity Card");
                    System.out.println("5. Phone Number");
                    System.out.println("6. Email Address");
                    System.out.println("7. Level");
                    System.out.println("8. Position");
                    System.out.println("9. Salary");
                    System.out.println("10. Exit");
                    System.out.println("Enter information you want to change: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1: {
                            System.out.println("Enter new Name: ");
                            String newName = scanner.nextLine();
                            e.setNamePerson(newName);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 2: {
                            System.out.println("Enter new Sex: ");
                            String newSex = scanner.nextLine();
                            e.setSex(newSex);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 3: {
                            System.out.println("Enter new Date of Birth: ");
                            String newDateOfBirth = scanner.nextLine();
                            e.setDateOfBirth(newDateOfBirth);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 4: {
                            System.out.println("Enter new Identity Card: ");
                            String newIdentityCard = scanner.nextLine();
                            e.setIdentityCard(newIdentityCard);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 5: {
                            System.out.println("Enter new Phone Number: ");
                            String newPhoneNumber = scanner.nextLine();
                            e.setPhoneNumber(newPhoneNumber);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 6: {
                            System.out.println("Enter new Email Address: ");
                            String newEmailAddress = scanner.nextLine();
                            e.setEmailAddress(newEmailAddress);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 7: {
                            System.out.println("Enter new Level ");
                            Level newLevel = Level.displayLevel();
                            e.setLevel(newLevel);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 8: {
                            System.out.println("Enter new Position ");
                            Position newPosition = Position.displayPosition();
                            e.setPosition(newPosition);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 9: {
                            System.out.println("Enter new Salary: ");
                            String newSalary = scanner.nextLine();
                            e.setEmailAddress(newSalary);
                            System.out.println("Successful Change!");
                            e.output();
                            break;
                        }

                        case 10: {
                            return;
                        }
                    }
                } else {
                    System.out.println("Not Found!");
                }
            }
        } while (true);
    }
}