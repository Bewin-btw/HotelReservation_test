package com.Hotel.hotelreservationsystem.service.impl;

import com.Hotel.hotelreservationsystem.dao.ReservationDAO;
import com.Hotel.hotelreservationsystem.dao.impl.ReservationDAOImpl;
import com.Hotel.hotelreservationsystem.model.Reservation;
import com.Hotel.hotelreservationsystem.service.ReservationService;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    private ReservationDAO reservationDAO = new ReservationDAOImpl();

    public void createReservation(Reservation reservation) {
        reservationDAO.addReservation(reservation);
    }

    public Reservation getReservationById(int id) {
        return reservationDAO.getReservationById(id);
    }

    public List<Reservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }

    public void updateReservation(Reservation reservation) {
        reservationDAO.updateReservation(reservation);
    }

    public void cancelReservation(int id) {
        reservationDAO.deleteReservation(id);
    }
}
