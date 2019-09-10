package com.CezaryZal.testDB;

import com.CezaryZal.config.DbConnector;

import java.sql.*;


public class ConnectDB {
    public static void main(String[] args) {

        try (Connection connection = DbConnector.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tolerancevalue.nominal_tolerance");


            while (resultSet.next()) {
                System.out.println(resultSet.getString("IT4[um]"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
