package com.Hotel.hotelreservationsystem.dao;

import com.Hotel.hotelreservationsystem.model.Guest;
import com.Hotel.hotelreservationsystem.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAOImpl implements GuestDAO{

    @Override
    public void addGuest(Guest guest){
        String sql = "INSERT INTO Guests (FirstName, LastName, Email, PhoneNumber) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, guest.getFirstName());
            pstmt.setString(2, guest.getLastName());
            pstmt.setString(3, guest.getEmail());
            pstmt.setString(4, guest.getPhoneNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Guest GetGuestById(int id) {
        String sql = "SELECT * FROM Guests WHERE GuestID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                return new Guest(
                        rs.getInt("GuestID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("PhoneNumber");
                )
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();
        String sql = "SELECT * FROM Guests";
        try (Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                guests.add(new Guest(
                        rs.getInt("GuestID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("PhoneNumber")
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return guests;
    }

    @Override
    public void updateGuest(Guest guest){
        String sql = "UPDATE Guests SET FirstName = ?, LastName = ?, Email = ?, PhoneNumber = ?, WHERE GuestID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(5, guest.getGuestID());
            pstmt.setString(1, guest.getFirstName());
            pstmt.setString(2, guest.getLastName());
            pstmt.setString(3, guest.getEmail());
            pstmt.setString(4, guest.getPhoneNumber());
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGuest(int id) {
        String sql = "DELETE FROM Guests WHERE GuestID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
