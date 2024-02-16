package com.Hotel.hotelreservationsystem.dao;

import com.Hotel.hotelreservationsystem.model.Guest;
import java.util.List;


public interface GuestDAO {
    void addGuest(Guest guest);
    Guest getGuestById(int id);
    List<Guest> getAllGuests();
    void updateGuest(Guest guest);
    void deleteGuest(int id);
}

