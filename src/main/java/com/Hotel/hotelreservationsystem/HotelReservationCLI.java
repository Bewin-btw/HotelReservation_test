package com.Hotel.hotelreservationsystem;

import com.Hotel.hotelreservationsystem.dao.impl.GuestDAOImpl;
import com.Hotel.hotelreservationsystem.model.*;
import com.Hotel.hotelreservationsystem.service.*;
import com.Hotel.hotelreservationsystem.service.impl.*;

import java.time.LocalDate;
import java.util.Scanner;

public class HotelReservationCLI {
    // Work on Dependency Injection (Inversion of Control [Инверсия зависимостей], Dependency Injection (@Autowired, Constructor Injection, Field Injection, Setter Injection))
    // Move Service classes into interfaces and implement them #DONE
    // Try to make menu methods non-static #DONE
    // Model classes shouldn't have logic #DONE
    // Connection Pool #DONE
    // Design Patterns (Abstract Factory, Factory Method, Builder, Strategy, State, Adapter, Decorator)
    // application.properties #DONE
    // Lombok

    private RoomService roomService;
    private ReservationService reservationService;
    private GuestService guestService;
    private StaffService staffService;
    private PaymentService paymentService;
    private Scanner scanner;

    public HotelReservationCLI() {
        this.roomService = new RoomServiceImpl(); // Done
        this.reservationService = new ReservationServiceImpl(); // Done
        this.guestService = new GuestServiceImpl(new GuestDAOImpl()); // Done
        this.staffService = new StaffServiceImpl(); // Done
        this.paymentService = new PaymentServiceImpl(); // Done
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to the Hotel Reservation System CLI");
            System.out.println("1. Manage Rooms");
            System.out.println("2. Manage Reservations");
            System.out.println("3. Manage Guests");
            System.out.println("4. Manage Staff");
            System.out.println("5. Process Payments");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manageRooms(scanner);
                    break;
                case 2:
                    manageReservations(scanner);
                    break;
                case 3:
                    manageGuests(scanner);
                    break;
                case 4:
                    manageStaff(scanner);
                    break;
                case 5:
                    processPayments(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private void manageRooms(Scanner scanner) {
        System.out.println("\nRoom Management");
        System.out.println("1. List all rooms");
        System.out.println("2. Add a new room");
        System.out.println("3. Update a room");
        System.out.println("4. Delete a room");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                roomService.getAllRooms().forEach(System.out::println);
                break;
            case 2:
                System.out.println("Enter Room Number:");
                String roomNumber = scanner.nextLine();
                System.out.println("Enter Room Type:");
                String roomType = scanner.nextLine();
                System.out.println("Enter Price:");
                double price = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter Status (available/booked):");
                String status = scanner.nextLine();

                Room room = new Room(0, roomNumber, roomType, price, status);
                roomService.addRoom(room);
                System.out.println("Room added successfully.");
                break;
            case 3:
                System.out.println("Enter Room ID to update:");
                int roomIdToUpdate = scanner.nextInt();
                scanner.nextLine();
                Room roomToUpdate = roomService.getRoomById(roomIdToUpdate);
                if (roomToUpdate != null) {
                    System.out.println("Enter updated Room Number (current: " + roomToUpdate.getRoomNumber() + "):");
                    roomToUpdate.setRoomNumber(scanner.nextLine());
                    System.out.println("Enter updated Room Type (current: " + roomToUpdate.getRoomType() + "):");
                    roomToUpdate.setRoomType(scanner.nextLine());
                    System.out.println("Enter updated Price (current: " + roomToUpdate.getPrice() + "):");
                    roomToUpdate.setPrice(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.println("Enter updated Status (available/booked, current: " + roomToUpdate.getStatus() + "):");
                    roomToUpdate.setStatus(scanner.nextLine());

                    roomService.updateRoom(roomToUpdate);
                    System.out.println("Room updated successfully.");
                } else {
                    System.out.println("Room not found.");
                }
                break;
            case 4:
                System.out.println("Enter Room ID to delete:");
                int roomId = scanner.nextInt();
                roomService.deleteRoom(roomId);
                System.out.println("Room deleted successfully.");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }


    private void manageReservations(Scanner scanner) {
        System.out.println("\nReservation Management");
        System.out.println("1. Create a new reservation");
        System.out.println("2. View a reservation");
        System.out.println("3. Update a reservation");
        System.out.println("4. Cancel a reservation");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter Guest ID:");
                int guestIdForReservation = scanner.nextInt();
                System.out.println("Enter Room ID:");
                int roomIdForReservation = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Check-In Date (YYYY-MM-DD):");
                String checkInDate = scanner.nextLine();
                System.out.println("Enter Check-Out Date (YYYY-MM-DD):");
                String checkOutDate = scanner.nextLine();
                System.out.println("Enter Number of Guests:");
                int numberOfGuests = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Reservation Status:");
                String status = scanner.nextLine();

                Reservation newReservation = new Reservation(0, guestIdForReservation, roomIdForReservation, LocalDate.parse(checkInDate), LocalDate.parse(checkOutDate), numberOfGuests, status);
                reservationService.createReservation(newReservation);
                System.out.println("Reservation created successfully.");
                break;
            case 2:
                System.out.println("Enter Reservation ID:");
                int reservationId = scanner.nextInt();
                Reservation reservation = reservationService.getReservationById(reservationId);
                System.out.println(reservation);
                break;
            case 3:
                System.out.println("Enter Reservation ID to update:");
                int reservationIdToUpdate = scanner.nextInt();
                scanner.nextLine();
                Reservation reservationToUpdate = reservationService.getReservationById(reservationIdToUpdate);
                if (reservationToUpdate != null) {
                    System.out.println("Enter updated Room ID (current: " + reservationToUpdate.getRoomID() + "):");
                    reservationToUpdate.setRoomID(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter updated Check-In Date (YYYY-MM-DD, current: " + reservationToUpdate.getCheckInDate() + "):");
                    reservationToUpdate.setCheckInDate(LocalDate.parse(scanner.nextLine()));
                    System.out.println("Enter updated Check-Out Date (YYYY-MM-DD, current: " + reservationToUpdate.getCheckOutDate() + "):");
                    reservationToUpdate.setCheckOutDate(LocalDate.parse(scanner.nextLine()));
                    System.out.println("Enter updated Number of Guests (current: " + reservationToUpdate.getNumberOfGuests() + "):");
                    reservationToUpdate.setNumberOfGuests(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter updated Status (current: " + reservationToUpdate.getStatus() + "):");
                    reservationToUpdate.setStatus(scanner.nextLine());

                    reservationService.updateReservation(reservationToUpdate);
                    System.out.println("Reservation updated successfully.");
                } else {
                    System.out.println("Reservation not found.");
                }
                break;

            case 4:
                System.out.println("Enter Reservation ID to cancel:");
                int cancelId = scanner.nextInt();
                reservationService.cancelReservation(cancelId);
                System.out.println("Reservation cancelled successfully.");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }


    private void manageGuests(Scanner scanner) {
        System.out.println("\nGuest Management");
        System.out.println("1. List all guests");
        System.out.println("2. Add a new guest");
        System.out.println("3. Update a guest");
        System.out.println("4. Delete a guest");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                guestService.getAllGuests().forEach(System.out::println);
                break;
            case 2:
                System.out.println("Enter First Name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter Last Name:");
                String lastName = scanner.nextLine();
                System.out.println("Enter Email:");
                String email = scanner.nextLine();
                System.out.println("Enter Phone Number:");
                String phoneNumber = scanner.nextLine();

                Guest newGuest = new Guest(0, firstName, lastName, email, phoneNumber);
                guestService.addGuest(newGuest);
                System.out.println("Guest added successfully.");
                break;
            case 3:
                System.out.println("Enter Guest ID to update:");
                int guestIdToUpdate = scanner.nextInt();
                scanner.nextLine();
                Guest guestToUpdate = guestService.getGuestByID(guestIdToUpdate);
                if (guestToUpdate != null) {
                    System.out.println("Enter updated First Name (current: " + guestToUpdate.getFirstName() + "):");
                    guestToUpdate.setFirstName(scanner.nextLine());
                    System.out.println("Enter updated Last Name (current: " + guestToUpdate.getLastName() + "):");
                    guestToUpdate.setLastName(scanner.nextLine());
                    System.out.println("Enter updated Email (current: " + guestToUpdate.getEmail() + "):");
                    guestToUpdate.setEmail(scanner.nextLine());
                    System.out.println("Enter updated Phone Number (current: " + guestToUpdate.getPhoneNumber() + "):");
                    guestToUpdate.setPhoneNumber(scanner.nextLine());

                    guestService.updateGuest(guestToUpdate);
                    System.out.println("Guest updated successfully.");
                } else {
                    System.out.println("Guest not found.");
                }
                break;
            case 4:
                System.out.println("Enter Guest ID to delete:");
                int guestId = scanner.nextInt();
                guestService.deleteGuest(guestId);
                System.out.println("Guest deleted successfully.");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }


    private void manageStaff(Scanner scanner) {
        System.out.println("\nStaff Management");
        System.out.println("1. List all staff");
        System.out.println("2. Add new staff");
        System.out.println("3. Update staff details");
        System.out.println("4. Delete staff");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                staffService.getAllStaff().forEach(System.out::println);
                break;
            case 2:
                System.out.println("Enter Staff First Name:");
                String staffFirstName = scanner.nextLine();
                System.out.println("Enter Staff Last Name:");
                String staffLastName = scanner.nextLine();
                System.out.println("Enter Staff Position:");
                String staffPosition = scanner.nextLine();
                System.out.println("Enter Staff Email:");
                String staffEmail = scanner.nextLine();

                Staff newStaff = new Staff(0, staffFirstName, staffLastName, staffPosition, staffEmail);
                staffService.addStaff(newStaff);
                System.out.println("New staff member added successfully.");
                break;

            case 3:
                System.out.println("Enter Staff ID to update:");
                int staffIdToUpdate = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter updated First Name:");
                String updatedFirstName = scanner.nextLine();
                System.out.println("Enter updated Last Name:");
                String updatedLastName = scanner.nextLine();
                System.out.println("Enter updated Email:");
                String updatedEmail = scanner.nextLine();
                System.out.println("Enter updated Position:");
                String updatedPosition = scanner.nextLine();

                Staff staffToUpdate = staffService.getStaffById(staffIdToUpdate);
                staffToUpdate.setFirstName(updatedFirstName);
                staffToUpdate.setLastName(updatedLastName);
                staffToUpdate.setEmail(updatedEmail);
                staffToUpdate.setPosition(updatedPosition);
                staffService.updateStaff(staffToUpdate);
                System.out.println("Staff details updated successfully.");
                break;

            case 4:
                System.out.println("Enter Staff ID to delete:");
                int staffId = scanner.nextInt();
                staffService.deleteStaff(staffId);
                System.out.println("Staff deleted successfully.");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }


    private void processPayments(Scanner scanner) {
        System.out.println("\nPayment Processing");
        System.out.println("1. Process a new payment");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter Reservation ID:");
                int reservationIdForPayment = scanner.nextInt();
                System.out.println("Enter Amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter Payment Date (YYYY-MM-DD):");
                String paymentDate = scanner.nextLine();
                System.out.println("Enter Payment Method:");
                String paymentMethod = scanner.nextLine();

                Payment newPayment = new Payment(0, reservationIdForPayment, amount, LocalDate.parse(paymentDate), paymentMethod);
                paymentService.processPayment(newPayment);
                System.out.println("Payment processed successfully.");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
    public static void main(String[] args) {
        HotelReservationCLI cli = new HotelReservationCLI();
        cli.start();
    }
}
