package com.Hotel.hotelreservationsystem.model;

public class InvalidInputException extends Exception{
    public InvalidInputException(String message){
        super(message);
    }
}
