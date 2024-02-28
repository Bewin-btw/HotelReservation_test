package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.dao.ReservationDAO;
import com.Hotel.hotelreservationsystem.dao.impl.ReservationDAOImpl;
import com.Hotel.hotelreservationsystem.model.Reservation;
import java.util.List;

public interface ReservationService {
    void createReservation(Reservation reservation);

    Reservation getReservationById(int id);

    List<Reservation> getAllReservations();

    void updateReservation(Reservation reservation);

    void cancelReservation(int id);
}
