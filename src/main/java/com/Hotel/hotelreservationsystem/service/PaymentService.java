package com.Hotel.hotelreservationsystem.service;

import com.Hotel.hotelreservationsystem.dao.PaymentDAO;
import com.Hotel.hotelreservationsystem.dao.impl.PaymentDAOImpl;
import com.Hotel.hotelreservationsystem.model.Payment;
import java.util.List;

public class PaymentService {
    private PaymentDAO paymentDAO = new PaymentDAOImpl();

    public void processPayment(Payment payment) {
        paymentDAO.addPayment(payment);
        System.out.println("Payment was proceed");
    }

    public Payment getPaymentById(int id) {
        return paymentDAO.getPaymentById(id);
    }

}
