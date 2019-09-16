package com.CezaryZal.config;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {


    public static Connection getConnection() throws SQLException {

        final String JDB_URL = "jdbc:mysql://localhost:3306/dimension_tolerance?useSSL=false&serverTimezone=UTC";
        final String USERNAME = "hbstudent";
        final String PASSWORD = "HBstudent!123";
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (Connection) DriverManager.getConnection(JDB_URL, USERNAME, PASSWORD);
    }
}
