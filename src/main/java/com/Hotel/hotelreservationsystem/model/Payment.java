package com.Hotel.hotelreservationsystem.model;

import java.time.LocalDate;

public class Payment {
    private int paymentID;
    private int reservationID;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;

    public Payment(int paymentID, int reservationID, double amount, LocalDate paymentDate, String paymentMethod) {
        this.paymentID = paymentID;
        this.reservationID = reservationID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void displayPaymentDetails() {
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Reservation ID: " + reservationID);
        System.out.println("Amount: $" + amount);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Payment Method: " + paymentMethod);
    }

    public boolean validatePayment() {
        return amount > 0 && paymentMethod != null && !paymentMethod.isEmpty();
    }
}
