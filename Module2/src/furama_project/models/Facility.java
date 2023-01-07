package furama_project.models;

import furama_project.type.RentalType;

public abstract class Facility {
    protected String serviecName;
    protected double usableArea;
    protected double rentalCosts;
    protected int maximumPeople;
    protected RentalType rentalType;

    public Facility() {
    }

    public Facility(String serviecName, double usableArea, double rentalCosts, int maximumPeople, RentalType rentalType) {
        this.serviecName = serviecName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
    }

    public String getServiecName() {
        return serviecName;
    }

    public void setServiecName(String serviecName) {
        this.serviecName = serviecName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

}
