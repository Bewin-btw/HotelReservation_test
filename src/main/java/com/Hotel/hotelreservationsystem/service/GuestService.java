package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.dao.GuestDAO;
import com.Hotel.hotelreservationsystem.dao.StaffDAO;
import com.Hotel.hotelreservationsystem.dao.impl.GuestDAOImpl;
import com.Hotel.hotelreservationsystem.model.Guest;
import com.Hotel.hotelreservationsystem.model.Staff;

import java.util.List;

public class GuestService {
    private GuestDAO guestDAO = new GuestDAOImpl();

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
