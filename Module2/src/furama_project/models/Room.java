package furama_project.models;

import furama_project.type.RentalType;

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
}
