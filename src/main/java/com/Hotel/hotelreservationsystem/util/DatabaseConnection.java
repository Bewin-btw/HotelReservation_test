package com.Hotel.hotelreservationsystem.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("application");
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(bundle.getString("database.url"));
        config.setUsername(bundle.getString("database.user"));
        config.setPassword(bundle.getString("database.password"));

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
