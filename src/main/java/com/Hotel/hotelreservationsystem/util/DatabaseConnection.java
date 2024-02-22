package com.Hotel.hotelreservationsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "bewin";
    private static final String PASSWORD = "0412";

    public static Connection getConnection() throws SQLException { // Connection Pool (HikariPool)
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
