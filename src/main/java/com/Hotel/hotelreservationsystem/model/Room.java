package com.Hotel.hotelreservationsystem.model;

public class Room {
    private int roomID;
    private String roomNumber;
    private String roomType;
    private double price;
    private String status;

    public Room(int roomID, String roomNumber, String roomType, double price, String status) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.status = status;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayRoomDetails() {
        System.out.println("Room ID: " + roomID);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price: $" + price);
        System.out.println("Status: " + status);
    }

    public boolean isAvailable() {
        return status.equalsIgnoreCase("available");
    }
}
