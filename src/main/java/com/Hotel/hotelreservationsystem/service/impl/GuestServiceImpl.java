package com.Hotel.hotelreservationsystem.service.impl;

import com.Hotel.hotelreservationsystem.service.GuestService;
import com.Hotel.hotelreservationsystem.dao.GuestDAO;
import com.Hotel.hotelreservationsystem.model.Guest;

import java.util.List;

public class GuestServiceImpl implements GuestService{
    private final GuestDAO guestDAO;

    public GuestServiceImpl(GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }

    public void addGuest(Guest guest){
        guestDAO.addGuest(guest);
    }

    public Guest getGuestByID(int id) {
        return guestDAO.getGuestById(id);
    }

    public List<Guest> getAllGuests(){
        return guestDAO.getAllGuests();
    }

    public void updateGuest(Guest guest){
        guestDAO.updateGuest(guest);
    }

    public void deleteGuest(int id){
        guestDAO.deleteGuest(id);
    }
}
