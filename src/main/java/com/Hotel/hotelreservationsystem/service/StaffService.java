package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.dao.StaffDAO;
import com.Hotel.hotelreservationsystem.dao.impl.StaffDAOImpl;
import com.Hotel.hotelreservationsystem.model.Staff;
import java.util.List;

public interface StaffService {
    void addStaff(Staff staff);

    Staff getStaffById(int id);

    List<Staff> getAllStaff();

    void updateStaff(Staff staff);

    void deleteStaff(int id);
}
