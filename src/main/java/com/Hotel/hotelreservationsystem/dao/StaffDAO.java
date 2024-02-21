package com.Hotel.hotelreservationsystem.dao;

import com.Hotel.hotelreservationsystem.model.Staff;

import java.util.List;

public interface StaffDAO {
    void addStaff(Staff staff);
    Staff getStaffById(int id);
    List<Staff> getAllStaff();
    void updateStaff(Staff staff);
    void deleteStaff(int id);
}
