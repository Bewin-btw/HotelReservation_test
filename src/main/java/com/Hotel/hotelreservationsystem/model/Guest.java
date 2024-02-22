package com.Hotel.hotelreservationsystem.model;

public class Guest {
    private int guestID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Guest{" +
                "guestID=" + guestID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Guest(int guestID, String firstName, String lastName, String email, String phoneNumber) {
        this.guestID = guestID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void displayDetails() {
        System.out.println("Guest ID: " + guestID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }

    public void updateContactInfo(String newEmail, String newPhoneNumber) {
        setEmail(newEmail);
        setPhoneNumber(newPhoneNumber);
        System.out.println("Contact information updated successfully.");
    }

    public boolean isValidEmail() {
        return email != null && email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    public boolean isValidPhoneNumber() {
        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }
}
