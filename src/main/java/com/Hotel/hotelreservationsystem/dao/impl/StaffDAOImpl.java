package com.Hotel.hotelreservationsystem.dao.impl;

import com.Hotel.hotelreservationsystem.dao.StaffDAO;
import com.Hotel.hotelreservationsystem.model.Staff;
import com.Hotel.hotelreservationsystem.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {

    @Override
    public void addStaff(Staff staff) {
        String sql = "INSERT INTO Staff (FirstName, LastName, Position, Email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getFirstName());
            pstmt.setString(2, staff.getLastName());
            pstmt.setString(3, staff.getPosition());
            pstmt.setString(4, staff.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Staff getStaffById(int id) {
        String sql = "SELECT * FROM Staff WHERE StaffID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Staff(rs.getInt("StaffID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Position"),
                        rs.getString("Email"));
            } else {
                throw new IllegalArgumentException("Staff not found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM Staff";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                staffList.add(new Staff(
                        rs.getInt("StaffID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Position"),
                        rs.getString("Email")
                ));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return staffList;
    }

    @Override
    public void updateStaff(Staff staff) {
        String sql = "UPDATE Staff SET FirstName = ?, LastName = ?, Position = ?, Email = ? WHERE StaffID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getFirstName());
            pstmt.setString(2, staff.getLastName());
            pstmt.setString(3, staff.getPosition());
            pstmt.setString(4, staff.getEmail());
            pstmt.setInt(5, staff.getStaffID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void deleteStaff(int id) {
        String sql = "DELETE FROM Staff WHERE StaffID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
