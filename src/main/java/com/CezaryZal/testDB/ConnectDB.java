package com.CezaryZal.testDB;

import java.sql.*;


public class ConnectDB {
    public static void main(String[] args) {

        final String JDB_URL = "jdbc:mysql://localhost:3306/tolerancevalue?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        final String USENAME = "root";
        final String PASSWORD = "SQLSerwer2019!@";

        try (Connection connection = DriverManager.getConnection(JDB_URL, USENAME, PASSWORD)) {

            System.out.println("Test connect");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tolerancevalue.nominal_tolerance");

//            ContactService contactService;
//            List<Contact> contacts = contactService.getContacts();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("IT4[um]"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
