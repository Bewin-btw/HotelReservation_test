package com.Hotel.hotelreservationsystem.dao.impl;

import com.Hotel.hotelreservationsystem.dao.RoomDAO;
import com.Hotel.hotelreservationsystem.model.Room;
import com.Hotel.hotelreservationsystem.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public void addRoom(Room room) {
        String sql = "INSERT INTO Rooms (RoomNumber, RoomType, Price, Status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setDouble(3, room.getPrice());
            pstmt.setString(4, room.getStatus());
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Room getRoomById(int id) {
        String sql = "SELECT * FROM Rooms WHERE RoomID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Room(rs.getInt("RoomID"),
                        rs.getString("RoomNumber"),
                        rs.getString("RoomType"),
                        rs.getDouble("Price"),
                        rs.getString("Status"));
            } else {
                throw new IllegalArgumentException();
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Rooms";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rooms.add(new Room(
                        rs.getInt("RoomID"),
                        rs.getString("RoomNumber"),
                        rs.getString("RoomType"),
                        rs.getInt("Price"),
                        rs.getString("Status")
                ));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return rooms;
    }

    @Override
    public void updateRoom(Room room) {
        String sql = "UPDATE Rooms SET RoomNumber = ?, RoomType = ?, Price = ?, Status = ? WHERE RoomID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setDouble(3, room.getPrice());
            pstmt.setString(4, room.getStatus());
            pstmt.setDouble(5, room.getRoomID());
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void deleteRoom(int id) {
        String sql = "DELETE FROM Rooms WHERE RoomID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
