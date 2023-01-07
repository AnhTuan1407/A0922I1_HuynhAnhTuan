package furama_project.models;

import furama_project.type.RentalType;

public class House extends Facility{
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

}
