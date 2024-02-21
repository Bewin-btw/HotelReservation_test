package com.Hotel.hotelreservationsystem.dao.impl;

import com.Hotel.hotelreservationsystem.dao.ReservationDAO;
import com.Hotel.hotelreservationsystem.model.Reservation;
import com.Hotel.hotelreservationsystem.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public void addReservation(Reservation reservation) {
        String sql = "INSERT INTO reservations (guestid, roomid, checkindate, checkoutdate, numberofguests," +
                "status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reservation.getGuestID());
            pstmt.setInt(2, reservation.getRoomID());
            pstmt.setDate(3, Date.valueOf(reservation.getCheckInDate()));
            pstmt.setDate(4, Date.valueOf(reservation.getCheckOutDate()));
            pstmt.setInt(5, reservation.getNumberOfGuests());
            pstmt.setString(6, reservation.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Reservation getReservationById(int id) {
        Reservation reservation = null;
        String sql = "SELECT * FROM reservations WHERE reservationid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                reservation = new Reservation(
                        id,
                        rs.getInt("guestid"),
                        rs.getInt("roomid"),
                        rs.getDate("checkindate").toLocalDate(),
                        rs.getDate("checkoutdate").toLocalDate(),
                        rs.getInt("numberofguests"),
                        rs.getString("status")
                );
            } else {
                throw new IllegalArgumentException("Reservation with id: " + id + " not found");
            }
            return reservation;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getInt("reservationid"),
                        rs.getInt("guestid"),
                        rs.getInt("roomid"),
                        rs.getDate("checkindate").toLocalDate(),
                        rs.getDate("chekoutdate").toLocalDate(),
                        rs.getInt("numberofguests"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return reservations;
    }

    @Override
    public void updateReservation(Reservation reservation) {
        String sql = "UPDATE reservations SET guestid = ?, roomid = ?, checkindate = ?, checkoutdate = ?," +
                "numberofguests = ?, status = ? WHERE reservationid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reservation.getGuestID());
            pstmt.setInt(2, reservation.getRoomID());
            pstmt.setDate(3, Date.valueOf(reservation.getCheckInDate()));
            pstmt.setDate(4, Date.valueOf(reservation.getCheckOutDate()));
            pstmt.setInt(5, reservation.getNumberOfGuests());
            pstmt.setString(6, reservation.getStatus());
            pstmt.setInt(7, reservation.getReservationID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void deleteReservation(int id) {
        String sql = "DELETE FROM reservations WHERE reservationid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
