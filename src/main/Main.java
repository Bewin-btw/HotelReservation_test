package com.Hotel;

import com.Hotel.hotelreservationsystem.model.HRS;
import com.Hotel.hotelreservationsystem.model.Guest;
import com.Hotel.hotelreservationsystem.model.Payment;
import com.Hotel.hotelreservationsystem.model.Room;
import com.Hotel.hotelreservationsystem.model.Reservation;
import com.Hotel.hotelreservationsystem.model.Staff;
import java.time.LocalDate;

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

        Payment payment = new Payment(1, 1, 100.0, LocalDate.now(), "Credit Card");
        payment.displayPaymentDetails();

        if (payment.isAmountValid()) {
            System.out.println("Payment amount is valid.");
        } else {
            System.out.println("Invalid payment amount.");
        }

        if (payment.isPaymentMethodValid()) {
            System.out.println("Payment method is valid.");
        } else {
            System.out.println("Invalid payment method.");
        }

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
