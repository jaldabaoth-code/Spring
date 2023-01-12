package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcUpdate;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.util.jdbc.jdbcUpdate.JdbcUpdateUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* Quest : JDBC Update */
public class JdbcUpdateSchoolRepository {
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
            JdbcUpdateUtils.closeResultSet(resultSet);
            JdbcUpdateUtils.closeStatement(statement);
            JdbcUpdateUtils.closeConnection(connection);
        }
        return null;
    }

    public School update(Long id, String name, Long capacity, String country) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("UPDATE school SET name=?, capacity=?, country=? WHERE id=?");
            statement.setString(1, name);
            statement.setLong(2, capacity);
            statement.setString(3, country);
            statement.setLong(4, id);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return new School(id, name, capacity, country);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUpdateUtils.closeStatement(statement);
            JdbcUpdateUtils.closeConnection(connection);
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
            JdbcUpdateUtils.closeResultSet(resultSet);
            JdbcUpdateUtils.closeStatement(statement);
            JdbcUpdateUtils.closeConnection(connection);
        }
        return null;
    }
}
