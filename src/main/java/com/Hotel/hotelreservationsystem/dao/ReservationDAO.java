package com.Hotel.hotelreservationsystem.dao;

import com.Hotel.hotelreservationsystem.model.Reservation;
import java.util.List;

public interface ReservationDAO {
    void addReservation(Reservation reservation);
    Reservation getReservationById(int id);
    List<Reservation> getAllReservations();
    void updateReservation(Reservation reservation);
    void deleteReservation(int id);
}
