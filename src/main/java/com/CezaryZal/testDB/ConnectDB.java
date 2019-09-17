package com.CezaryZal.testDB;

import com.CezaryZal.config.DbConnector;

import java.sql.*;


public class ConnectDB {
    public static void main(String[] args) {

        int currentNominalDimension = 6;
        String currentSign = "c";

        try (Connection connection = DbConnector.getConnection()) {

            Statement statement = connection.createStatement();

//            ResultSet resultSet = statement.executeQuery("SELECT value FROM dimension_tolerance.basic_deviations " +
//                    "where " + currentNominalDimension + " between nominal_dimension_min and nominal_dimension_max " +
//                    "and sign = " + currentSign);



            PreparedStatement stat = connection.prepareStatement("SELECT value FROM dimension_tolerance.basic_deviations " +
                    "where ? between nominal_dimension_min and nominal_dimension_max and sign=?");
            stat.setInt(1, currentNominalDimension);
            stat.setString(2, currentSign);
            ResultSet resultSet = stat.executeQuery();

            if (resultSet.next()){
                System.out.println(resultSet.getString("value"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


//        SELECT value FROM dimension_tolerance.basic_deviations
//        where 6 between nominal_dimension_min and nominal_dimension_max and sign = 'c';

    }
}
