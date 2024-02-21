package com.Hotel.hotelreservationsystem.dao;

import com.Hotel.hotelreservationsystem.model.Room;
import java.util.List;

public interface RoomDAO {
    void addRoom(Room room);
    Room getRoomById(int id);
    List<Room> getAllRooms();
    void updateRoom(Room room);
    void deleteRoom(int id);
}
