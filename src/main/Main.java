package com.Hotel;

import com.Hotel.hotelreservationsystem.model.HRS;

public class Main {
    public static void main(String[] args){
        HRS reservationSystem= new HRS();

        reservationSystem.makeReservation("Angela", 187); //invalid room number
        reservationSystem.makeReservation("Adam", 50); //valid reservation
        reservationSystem.makeReservation("Dylan", 435); //invalid room number

        reservationSystem.cancelReservation("Angela"); //reservation not found
        reservationSystem.cancelReservation("Adam"); //valid cancellation
        reservationSystem.cancelReservation("Dylan"); //reservation not found
    }
}
