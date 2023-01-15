package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcUpdate;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.util.jdbc.jdbcUpdate.JdbcUpdateUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* Quest : JDBC Update */
public class JdbcUpdateWizardRepository {
    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public void getDataParameters(String databaseUrl, String databaseUsername, String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
    }

    public List<Wizard> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM wizard;");
            resultSet = statement.executeQuery();
            List<Wizard> wizards = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date birthday = resultSet.getDate("birthday");
                String birthPlace = resultSet.getString("birth_place");
                String biography = resultSet.getString("biography");
                boolean muggle = resultSet.getBoolean("muggle");
                wizards.add(new Wizard(id, firstName, lastName, birthday, birthPlace, biography, muggle));
            }
            return wizards;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUpdateUtils.closeResultSet(resultSet);
            JdbcUpdateUtils.closeStatement(statement);
            JdbcUpdateUtils.closeConnection(connection);
        }
        return null;
    }

    public Wizard update(Long id, String firstName, String lastName, Date birthday, String birthPlace, String biography, boolean muggle) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("UPDATE wizard SET first_name=?, last_name=?, birthday=?, birth_place=?, biography=?, muggle=? WHERE id=?");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setDate(3, birthday);
            statement.setString(4, birthPlace);
            statement.setString(5, biography);
            statement.setBoolean(6, muggle);
            statement.setLong(7, id);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("Failed to update data");
            }
            return new Wizard(id, firstName, lastName, birthday, birthPlace, biography, muggle);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUpdateUtils.closeStatement(statement);
            JdbcUpdateUtils.closeConnection(connection);
        }
        return null;
    }

    public Wizard findById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM wizard WHERE id = ?;");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date birthday = resultSet.getDate("birthday");
                String birthPlace = resultSet.getString("birth_place");
                String biography = resultSet.getString("biography");
                boolean muggle = resultSet.getBoolean("muggle");
                return new Wizard(id, firstName, lastName, birthday, birthPlace, biography, muggle);
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
