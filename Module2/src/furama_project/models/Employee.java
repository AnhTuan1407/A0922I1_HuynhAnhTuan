package furama_project.models;

import furama_project.type.Level;
import furama_project.type.Position;

import java.util.Scanner;

public class Employee extends Person {
    Scanner scanner = new Scanner(System.in);
    protected Level level;
    protected Position position;
    protected double salary;

    public Employee() {
    }

    public Employee(String idPerson, String namePerson, String dateOfBirth, String sex, String identityCard, String phoneNumber, String emailAddress, Level level, Position position, double salary) {
        super(idPerson, namePerson, dateOfBirth, sex, identityCard, phoneNumber, emailAddress);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void input() {
        System.out.println("Enter ID Employee: ");
        this.idPerson = scanner.nextLine();
        System.out.println("Enter Name Employee: ");
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
        System.out.println("Enter Level: ");
        this.level = Level.displayLevel();
        System.out.println("Enter Position: ");
        this.position = Position.displayPosition();
        System.out.println("Enter Salary: ");
        this.salary = scanner.nextDouble();
    }

    public void output() {
        System.out.println("ID Employee: " + this.idPerson + "\t|| Name Employee: " + this.namePerson + "\t|| BirthDay: " + this.dateOfBirth + "\t|| Sex: " + this.sex + "\t|| Identity Card: " + this.identityCard + "\t|| Phone Number: " + this.phoneNumber + "\t|| Email Address: " + this.emailAddress + "\t|| Level: " + this.level + "\t|| Position: " + this.position + "\t|| Salary: " + this.salary);
    }
}
