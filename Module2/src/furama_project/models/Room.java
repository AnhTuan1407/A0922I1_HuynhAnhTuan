package furama_project.models;

import furama_project.type.RentalType;

import java.util.Scanner;

public class Room extends Facility{
    protected String freeService;

    public Room() {
    }

    public Room(String serviecName, double usableArea, double rentalCosts, int maximumPeople, RentalType rentalType, String freeService) {
        super(serviecName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
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
        System.out.println("Enter Free Service: ");
        this.freeService = scanner.nextLine();
    }

    public void output() {
        System.out.print("Service Name: " + this.serviecName + "\t\t|| Usable Area: " + this.usableArea + "\t\t|| Rental Cost: " + this.rentalCosts + "\t\t|| Maximum People: " + this.maximumPeople + "\t\t|| Rental Type: " + this.rentalType + "\t\t|| Free Service: " + this.freeService);
    }
}
