package furama_project.models;

import furama_project.type.RentalType;

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
}
