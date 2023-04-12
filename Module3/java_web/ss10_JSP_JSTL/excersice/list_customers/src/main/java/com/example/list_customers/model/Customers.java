package com.example.list_customers.model;

public class Customers {
    private String nameCustomer;
    private String dateOfBirth;
    private String address;
    private String image;

    public Customers(String nameCustomer, String dateOfBirth, String address, String image) {
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.image = image;
    }

    public Customers() {
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
