package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.dao.StaffDAO;
import com.Hotel.hotelreservationsystem.dao.impl.StaffDAOImpl;
import com.Hotel.hotelreservationsystem.model.Staff;
import java.util.List;

public class StaffService {
    private StaffDAO staffDAO = new StaffDAOImpl();

    public void addStaff(Staff staff) {
        staffDAO.addStaff(staff);
    }

    public Staff getStaffById(int id) {
        return staffDAO.getStaffById(id);
    }

    public List<Staff> getAllStaff() {
        return staffDAO.getAllStaff();
    }

    public void updateStaff(Staff staff) {
        staffDAO.updateStaff(staff);
    }

    public void deleteStaff(int id) {
        staffDAO.deleteStaff(id);
    }
}
