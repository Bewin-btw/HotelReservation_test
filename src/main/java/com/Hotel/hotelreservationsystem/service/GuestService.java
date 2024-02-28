package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.model.Guest;

import java.util.List;

public interface GuestService {

    void addGuest(Guest guest);

    Guest getGuestByID(int id);

    List<Guest> getAllGuests();

    void updateGuest(Guest guest);

    void deleteGuest(int id);
}
