package com.Hotel.hotelreservationsystem.dao.impl;

import com.Hotel.hotelreservationsystem.dao.PaymentDAO;
import com.Hotel.hotelreservationsystem.model.Payment;
import com.Hotel.hotelreservationsystem.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void addPayment(Payment payment) {
        String sql = "INSERT INTO Payments (ReservationID, Amount, PaymentDate, PaymentMethod) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getReservationID());
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setDate(3, Date.valueOf(payment.getPaymentDate()));
            pstmt.setString(4, payment.getPaymentMethod());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Payment getPaymentById(int id) {
        String sql = "SELECT * FROM payments WHERE paymentid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Payment(rs.getInt("paymentid"),
                        rs.getInt("reservationid"),
                        rs.getDouble("amount"),
                        rs.getDate("paymentdate").toLocalDate(),
                        rs.getString("paymentmethod"));
            } else {
                throw new IllegalArgumentException("Payment with id: " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                payments.add(new Payment(rs.getInt("paymentid"),
                        rs.getInt("reservationid"),
                        rs.getDouble("amount"),
                        rs.getDate("paymentdate").toLocalDate(),
                        rs.getString("paymentmethod")));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return payments;
    }

    @Override
    public void updatePayment(Payment payment) {
        String sql = "UPDATE Payments SET ReservationID = ?, Amount = ?, PaymentDate = ?, PaymentMethod = ? WHERE PaymentID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getReservationID());
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setDate(3, Date.valueOf(payment.getPaymentDate()));
            pstmt.setString(4, payment.getPaymentMethod());
            pstmt.setInt(5, payment.getPaymentID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void deletePayment(int id) {
        String sql = "DELETE FROM payments WHERE paymentid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
