package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcSelect;

import com.wildcodeschool.wildandwizard.entity.School;
import org.springframework.jdbc.support.JdbcUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* Quest : JDBC Select */
public class JdbcSelectSchoolRepository {
    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public void getDataParameters(String databaseUrl, String databaseUsername, String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
    }

    public List<School> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM school;");
            resultSet = statement.executeQuery();
            List<School> schools = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Long capacity = resultSet.getLong("capacity");
                String country = resultSet.getString("country");
                schools.add(new School(id, name, capacity, country));
            }
            return schools;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public School findById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM school WHERE id = ?;");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Long capacity = resultSet.getLong("capacity");
                String country = resultSet.getString("country");
                return new School(id, name, capacity, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public List<School> findByCountry(String country) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM school WHERE country LIKE ?;");
            statement.setString(1, country);
            resultSet = statement.executeQuery();
            List<School> schools = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Long capacity = resultSet.getLong("capacity");
                schools.add(new School(id, name, capacity, country));
            }
            return schools;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }
}
