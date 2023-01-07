package furama_project.models;

import furama_project.type.CustomerType;
import furama_project.type.Level;
import furama_project.type.Position;

import java.util.Scanner;

public class Customer extends Person{
    Scanner scanner = new Scanner(System.in);
    protected CustomerType customerType;
    protected String address;

    public Customer() {
    }

    public Customer(String idPerson, String namePerson, String dateOfBirth, String sex, String identityCard, String phoneNumber, String emailAddress, CustomerType customerType, String address) {
        super(idPerson, namePerson, dateOfBirth, sex, identityCard, phoneNumber, emailAddress);
        this.customerType = customerType;
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void input() {
        System.out.println("Enter ID Customer: ");
        this.idPerson = scanner.nextLine();
        System.out.println("Enter Name Customer: ");
        this.namePerson = scanner.nextLine();
        System.out.println("Enter Date of Birth: ");
        this.dateOfBirth = scanner.nextLine();
        System.out.println("Enter Sex: ");
        this.sex = scanner.nextLine();
        System.out.println("Enter Identity Card: ");
        this.identityCard = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        this.phoneNumber = scanner.nextLine();
        System.out.println("Enter Email Address: ");
        this.emailAddress = scanner.nextLine();
        System.out.println("Enter Customer Type: ");
        this.customerType = CustomerType.displayCustomerType();
        System.out.println("Enter Address: ");
        this.address = scanner.nextLine();
    }

    public void output() {
        System.out.println("ID Customer: " + this.idPerson + "\t|| Name Customer: " + this.namePerson + "\t|| BirthDay: " + this.dateOfBirth + "\t|| Sex: " + this.sex + "\t|| Identity Card: " + this.identityCard + "\t|| Phone Number: " + this.phoneNumber + "\t|| Email Address: " + this.emailAddress + "\t|| Customer Type: " + this.customerType + "\t|| Address: " + this.address);
    }
}
