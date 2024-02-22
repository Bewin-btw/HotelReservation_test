package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.dao.RoomDAO;
import com.Hotel.hotelreservationsystem.dao.impl.RoomDAOImpl;
import com.Hotel.hotelreservationsystem.model.Room;
import java.util.List;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAOImpl();

    public void addRoom(Room room) {
        roomDAO.addRoom(room);
    }

    public Room getRoomById(int id) {
        return roomDAO.getRoomById(id);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public void updateRoom(Room room) {
        roomDAO.updateRoom(room);
    }

    public void deleteRoom(int id) {
        roomDAO.deleteRoom(id);
    }
}
