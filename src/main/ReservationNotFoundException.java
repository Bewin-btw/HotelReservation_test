package com.Hotel.hotelreservationsystem.model;

public class ReservationNotFoundException extends Exception{
    public ReservationNotFoundException(String message){
        super(message);
    }
}
