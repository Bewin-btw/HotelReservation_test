package com.Hotel.hotelreservationsystem.model;

public class PaymentFailedException extends Exception{
    public PaymentFailedException(String message){
        super(message);
    }
}
