package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.dao.RoomDAO;
import com.Hotel.hotelreservationsystem.dao.impl.RoomDAOImpl;
import com.Hotel.hotelreservationsystem.model.Room;
import java.util.List;

public interface RoomService {
    void addRoom(Room room);

    Room getRoomById(int id);

    List<Room> getAllRooms();

    void updateRoom(Room room);

    void deleteRoom(int id);
}
