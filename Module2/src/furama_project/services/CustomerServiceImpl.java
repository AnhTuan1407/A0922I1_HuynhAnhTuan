package furama_project.services;

import furama_project.controllers.CustomerManagement;
import furama_project.controllers.EmployeeManagement;
import furama_project.models.Customer;
import furama_project.models.Employee;
import furama_project.type.CustomerType;
import furama_project.type.Level;
import furama_project.type.Position;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public void addNew() {
        Customer customer = new Customer();
        customer.input();
        customers.add(customer);
    }

    @Override
    public void display() {
        for (Customer c : customers) {
            c.output();
        }
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        for (Customer c : customers) {
            c.output();
        }
        do {
            System.out.println("Enter ID you want to change information: ");
            String id = scanner.nextLine();

            for (Customer c : customers) {
                if (c.getIdPerson().equals(id)) {
                    c.output();
                    System.out.println("1. Name");
                    System.out.println("2. Date of Birth");
                    System.out.println("3. Sex");
                    System.out.println("4. Identity Card");
                    System.out.println("5. Phone Number");
                    System.out.println("6. Email Address");
                    System.out.println("7. Customer Type");
                    System.out.println("8. Address");
                    System.out.println("9. Exit");
                    System.out.println("Enter information you want to change: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1: {
                            System.out.println("Enter new Name: ");
                            String newName = scanner.nextLine();
                            c.setNamePerson(newName);
                            System.out.println("Successful Change!");
                            c.output();
                            break;
                        }

                        case 2: {
                            System.out.println("Enter new Sex: ");
                            String newSex = scanner.nextLine();
                            c.setSex(newSex);
                            System.out.println("Successful Change!");
                            c.output();
                            break;
                        }

                        case 3: {
                            System.out.println("Enter new Date of Birth: ");
                            String newDateOfBirth = scanner.nextLine();
                            c.setDateOfBirth(newDateOfBirth);
                            System.out.println("Successful Change!");
                            c.output();
                            break;
                        }

                        case 4: {
                            System.out.println("Enter new Identity Card: ");
                            String newIdentityCard = scanner.nextLine();
                            c.setIdentityCard(newIdentityCard);
                            System.out.println("Successful Change!");
                            c.output();
                            break;
                        }

                        case 5: {
                            System.out.println("Enter new Phone Number: ");
                            String newPhoneNumber = scanner.nextLine();
                            c.setPhoneNumber(newPhoneNumber);
                            System.out.println("Successful Change!");
                            c.output();
                            break;
                        }

                        case 6: {
                            System.out.println("Enter new Email Address: ");
                            String newEmailAddress = scanner.nextLine();
                            c.setEmailAddress(newEmailAddress);
                            System.out.println("Successful Change!");
                            c.output();
                            break;
                        }

                        case 7: {
                            System.out.println("Enter new Customer Type ");
                            CustomerType customerType = CustomerType.displayCustomerType();
                            c.setCustomerType(customerType);
                            System.out.println("Successful Change!");
                            c.output();
                            break;
                        }

                        case 8: {
                            System.out.println("Enter new Address ");
                            String address = scanner.nextLine();
                            c.setAddress(address);
                            System.out.println("Successful Change!");
                            c.output();
                            break;
                        }

                        case 9: {
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
