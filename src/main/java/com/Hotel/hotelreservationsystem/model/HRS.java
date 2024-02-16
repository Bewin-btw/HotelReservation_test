package com.Hotel.hotelreservationsystem.model;

import java.util.*;

public class HRS {
    private List<Map<String, Object>> reservations;

    public HRS(){
        this.reservations = new ArrayList<>();
    }

    public void makeReservation(String firstName, int roomNumber){
        try{
            if(roomNumber < 1 || roomNumber > 100 ){
                throw new InvalidInputException("Invalid room number");
            }
            processPayment(firstName, roomNumber);

            Map<String, Object> reservation = new HashMap<>();
            reservation.put("firstName", firstName);
            reservation.put("roomNumber", roomNumber);
            reservations.add(reservation);
            System.out.println("Reservation made for " + firstName + " in room" + roomNumber);
        }
        catch (InvalidInputException | PaymentFailedException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cancelReservation(String firstName){
        try{
            boolean found = false;
            for (Iterator<Map<String, Object>> iterator = reservations.iterator(); iterator.hasNext();){
                Map<String, Object> reservation = iterator.next();
                if (reservation.get("firstName").equals(firstName)){
                    iterator.remove();
                    System.out.println("Reservation for " + firstName + " canceled");
                    found = true;
                    break;
                }
            }
             if (!found){
                 throw new ReservationNotFoundException("Reservation for " + firstName + " not found");
             }
        } catch(ReservationNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void processPayment(String firstName, int roomNumber) throws PaymentFailedException{
        System.out.println("Processing payment for " + firstName + " for room " + roomNumber);
    }
}

