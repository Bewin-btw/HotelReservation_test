package com.Hotel.hotelreservationsystem.model;

public class Staff {
    private int staffID;
    private String firstName;
    private String lastName;
    private String position;
    private String email;

    public Staff(int staffID, String firstName, String lastName, String position, String email) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID=" + staffID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayStaffDetails() {
        System.out.println("Staff ID: " + staffID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
    }

    public void updatePosition(String newPosition) {
        setPosition(newPosition);
        System.out.println("Position updated successfully.");
    }
}
