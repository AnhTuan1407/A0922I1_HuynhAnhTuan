package furama_project.models;

import furama_project.type.RentalType;

import java.util.Scanner;

public class House extends Facility {
    protected String roomStandard;
    protected double numberFloors;

    public House() {
    }

    public House(String serviecName, double usableArea, double rentalCosts, int maximumPeople, RentalType rentalType, String roomStandard, double numberFloors) {
        super(serviecName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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
        scanner.nextLine();
        this.roomStandard = scanner.nextLine();
        System.out.println("Enter Number Floors: ");
        this.numberFloors = scanner.nextInt();
    }

    public void output() {
        System.out.print("Service Name: " + this.serviecName + "\t\t|| Usable Area: " + this.usableArea + "\t\t|| Rental Cost: " + this.rentalCosts + "\t\t|| Maximum People: " + this.maximumPeople + "\t\t|| Rental Type: " + this.rentalType + "\t\t|| Room Standard: " + this.roomStandard + "\t\t|| Number Floors: " + this.numberFloors);
    }
}
