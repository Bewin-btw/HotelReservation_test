package com.Hotel.hotelreservationsystem.model;

import java.time.LocalDate;
import java.time.Period;

public class Reservation {
    private int reservationID;
    private int guestID;
    private int roomID;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private String status;

    public Reservation(int reservationID, int guestID, int roomID, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests, String status) {
        this.reservationID = reservationID;
        this.guestID = guestID;
        this.roomID = roomID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", guestID=" + guestID +
                ", roomID=" + roomID +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfGuests=" + numberOfGuests +
                ", status='" + status + '\'' +
                '}';
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
