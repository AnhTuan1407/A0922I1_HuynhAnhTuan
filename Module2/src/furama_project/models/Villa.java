package furama_project.models;

import furama_project.type.RentalType;

import java.util.Scanner;

public class Villa extends Facility {
    protected String roomStandard;
    protected double poolArea;
    protected double numberFloors;

    public Villa() {
    }

    public Villa(String serviecName, double usableArea, double rentalCosts, int maximumPeople, RentalType rentalType, String roomStandard, double poolArea, double numberFloors) {
        super(serviecName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public double getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(double numberFloors) {
        this.numberFloors = numberFloors;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Service Name: ");
        this.serviecName = scanner.nextLine();
        System.out.println("Enter Usable Area: ");
        this.usableArea = scanner.nextInt();
        System.out.println("Enter Rental Cost: ");
        this.rentalCosts = scanner.nextInt();
        System.out.println("Enter Maximum People: ");
        this.maximumPeople = scanner.nextInt();
        System.out.println("Enter Rental Type: ");
        this.rentalType = RentalType.displayRentalType();
        System.out.println("Enter Room Standard: ");
        this.roomStandard = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter Pool Area: ");
        this.poolArea = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Number Floors: ");
        this.numberFloors = scanner.nextInt();
    }

    public void output() {
        System.out.print("Service Name: " + this.serviecName + "\t\t|| Usable Area: " + this.usableArea + "\t\t|| Rental Cost: " + this.rentalCosts + "\t\t|| Maximum People: " + this.maximumPeople + "\t\t|| Rental Type: " + this.rentalType + "\t\t|| Room Standard: " + this.roomStandard + "\t\t|| Pool Area: " + this.poolArea + "\t\t|| Number Floors: " + this.numberFloors);
    }
}
