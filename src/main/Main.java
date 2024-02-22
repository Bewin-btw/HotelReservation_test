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

        Guest guest = new Guest(1, "John", "Doe", "john@example.com", "123456789");
        guest.displayDetails();
        guest.updateContactInfo("john.doe@example.com", "987654321");

        Room room = new Room(101, "101A", "Standard", 100.0, "Available");
        room.displayRoomDetails();
        System.out.println("Is the room available? " + room.isAvailable());

        LocalDate checkInDate = LocalDate.of(2024, 3, 1);
        LocalDate checkOutDate = LocalDate.of(2024, 3, 5);
        Reservation reservation = new Reservation(1, guest.getGuestID(), room.getRoomID(), checkInDate, checkOutDate, 2, "Confirmed");
        reservation.displayReservationDetails();
        System.out.println("Reservation duration: " + reservation.getReservationDuration() + " days");

        Staff staff = new Staff(1, "Jane", "Smith", "Receptionist", "jane@example.com");
        staff.displayStaffDetails();
        staff.updatePosition("Manager");
    }
}
