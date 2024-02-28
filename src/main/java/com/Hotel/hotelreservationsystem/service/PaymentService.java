package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.dao.PaymentDAO;
import com.Hotel.hotelreservationsystem.dao.impl.PaymentDAOImpl;
import com.Hotel.hotelreservationsystem.model.Payment;
import java.util.List;

public interface PaymentService {
    void processPayment(Payment payment);

    Payment getPaymentById(int id);

}
