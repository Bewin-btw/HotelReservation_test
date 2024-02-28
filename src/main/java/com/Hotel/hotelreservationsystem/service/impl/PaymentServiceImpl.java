package com.Hotel.hotelreservationsystem.service.impl;

import com.Hotel.hotelreservationsystem.dao.PaymentDAO;
import com.Hotel.hotelreservationsystem.dao.impl.PaymentDAOImpl;
import com.Hotel.hotelreservationsystem.model.Payment;
import com.Hotel.hotelreservationsystem.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    private PaymentDAO paymentDAO = new PaymentDAOImpl();

    public void processPayment(Payment payment) {
        paymentDAO.addPayment(payment);
        System.out.println("Payment was proceed");
    }

    public Payment getPaymentById(int id) {
        return paymentDAO.getPaymentById(id);
    }
}
