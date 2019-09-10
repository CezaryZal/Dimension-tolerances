package com.CezaryZal.repository;

import com.CezaryZal.config.DbConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DimensionRepository {

    public List<Integer> getListOfLowerDimension(String nameTable) {
        List<Integer> listDimensionsOfRecords = new ArrayList<>();

        try (Connection connection = DbConnector.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nameTable);

            while (resultSet.next()) {
                listDimensionsOfRecords.add(resultSet.getInt("lower_dimension[mm]"));
            }
        } catch (SQLException error) {
            System.out.println("Wysątpienie błedu. Proszę sprawdzić poprawność wpisania wymiaru.");
            System.out.println("Wychwycony błąd: " + error.getMessage());
        }
        return listDimensionsOfRecords;
    }

    public int getDeviationByValueAndIt(int valueOfRecord, int valueToleranceClass) {
        int valueFromDB = 0;
        String sqlQuery = "SELECT * FROM nominal_tolerance WHERE `lower_dimension[mm]`=?";
        String columnLabelForIT = "IT" + valueToleranceClass + "[um]";

        try (Connection connection = DbConnector.getConnection()) {

            PreparedStatement stat = connection.prepareStatement(sqlQuery);
            stat.setInt(1, valueOfRecord);
            ResultSet resultSet = stat.executeQuery();

            while (resultSet.next()) {
                valueFromDB = resultSet.getInt(columnLabelForIT);
            }

        } catch (SQLException error) {
            System.out.println("Wysątpienie błedu. Proszę sprawdzić poprawność wpisania wymiaru.");
            System.out.println("Wychwycony błąd: " + error.getMessage());
        }
        return valueFromDB;
    }

    public int getDeviationFromHoleOverHTable(int valueOfRecord1, String symbolFromInput) {
        int valueFromDB = 0;
        String sqlQuery = "SELECT * FROM basic_deviations_for_hole_over_symbol_h WHERE `lower_dimension[mm]` = ?";

        try (Connection connection = DbConnector.getConnection()) {

            PreparedStatement stat = connection.prepareStatement(sqlQuery);
            stat.setInt(1, valueOfRecord1);
            ResultSet resultSet = stat.executeQuery();

            while (resultSet.next()) {
                valueFromDB = resultSet.getInt(symbolFromInput);
            }

        } catch (SQLException error) {
            System.out.println("Wysątpienie błedu. Proszę sprawdzić poprawność wpisania wymiaru.");
            System.out.println("Wychwycony błąd: " + error.getMessage());
        }
        return valueFromDB;
    }

    public int getDeviationFromHoleUnderHTable(int valueOfRecord, String symbolFromInput) {
        int valueFromDB = 0;
        String sqlQuery = "SELECT * FROM basic_deviations_for_hole_under_symbol_h WHERE `lower_dimension[mm]` = ?";

        System.out.println("zmienne: value of record " + valueOfRecord + "\n symbol from input: " + symbolFromInput + "\nSql query: " + sqlQuery);

        try (Connection connection = DbConnector.getConnection()) {

            PreparedStatement stat = connection.prepareStatement(sqlQuery);
            stat.setInt(1, valueOfRecord);
            ResultSet resultSet = stat.executeQuery();

            while (resultSet.next()) {
                valueFromDB = resultSet.getInt(symbolFromInput);
            }

        } catch (SQLException error) {
            System.out.println("Wysątpienie błedu. Proszę sprawdzić poprawność wpisania wymiaru.");
            System.out.println("Wychwycony błąd: " + error.getMessage());
        }
        return valueFromDB;
    }

    public int getDeviationFromShaftOverHTable(int valueOfRecord, String symbolFromInput) {
        int valueFromDB = 0;
        String sqlQuery = "SELECT * FROM basic_deviations_for_shaft_over_symbol_h WHERE `lower_dimension[mm]` = ?";

        try (Connection connection = DbConnector.getConnection()) {

            PreparedStatement stat = connection.prepareStatement(sqlQuery);
            stat.setInt(1, valueOfRecord);
            ResultSet resultSet = stat.executeQuery();

            while (resultSet.next()) {
                valueFromDB = resultSet.getInt(symbolFromInput);
            }

        } catch (SQLException error) {
            System.out.println("Wysątpienie błedu. Proszę sprawdzić poprawność wpisania wymiaru.");
            System.out.println("Wychwycony błąd: " + error.getMessage());
        }
        return valueFromDB;
    }

    public int getDeviationFromShaftUnderHTable(int valueOfRecord, String symbolFromInput) {
        int valueFromDB = 0;
        String sqlQuery = "SELECT * FROM basic_deviations_for_shaft_under_symbol_h WHERE `lower_dimension[mm]` = ?";

        try (Connection connection = DbConnector.getConnection()) {

            PreparedStatement stat = connection.prepareStatement(sqlQuery);
            stat.setInt(1, valueOfRecord);
            ResultSet resultSet = stat.executeQuery();

            while (resultSet.next()) {
                valueFromDB = resultSet.getInt(symbolFromInput);
            }

        } catch (SQLException error) {
            System.out.println("Wysątpienie błedu. Proszę sprawdzić poprawność wpisania wymiaru.");
            System.out.println("Wychwycony błąd: " + error.getMessage());
        }
        return valueFromDB;
    }

    public int getDeviationFromAdditionTable(int valueOfRecord, int valueToleranceClass) {
        int valueFromDB = 0;
        String sqlQuery = "SELECT * FROM addition_for_hole_over_symbol_h WHERE `lower_dimension[mm]` = ?";
        String columnLabelForIT = "IT" + valueToleranceClass;

        try (Connection connection = DbConnector.getConnection()) {

            PreparedStatement stat = connection.prepareStatement(sqlQuery);
            stat.setInt(1, valueOfRecord);
            ResultSet resultSet = stat.executeQuery();

            while (resultSet.next()) {
                valueFromDB = resultSet.getInt(columnLabelForIT);
            }

        } catch (SQLException error) {
            System.out.println("Wysątpienie błedu. Proszę sprawdzić poprawność wpisania wymiaru.");
            System.out.println("Wychwycony błąd: " + error.getMessage());
        }
        return valueFromDB;
    }
}
