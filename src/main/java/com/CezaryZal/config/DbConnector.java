package com.CezaryZal.config;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {


    public static Connection getConnection() throws SQLException {

//        final String JDB_URL = "jdbc:mysql://localhost:3306/tolerancevalue?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        final String JDB_URL = "jdbc:mysql://localhost:3306/tolerancevalue?useSSL=false";
        final String USERNAME = "root";
        final String PASSWORD = "SQLSerwer2019!@";
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (Connection) DriverManager.getConnection(JDB_URL, USERNAME, PASSWORD);
    }
}
