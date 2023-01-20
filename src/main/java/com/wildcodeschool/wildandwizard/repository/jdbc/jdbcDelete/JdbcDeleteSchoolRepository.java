package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcDelete;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.util.jdbc.jdbcDelete.JdbcDeleteUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* Quest : JDBC Delete */
public class JdbcDeleteSchoolRepository {
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
            JdbcDeleteUtils.closeResultSet(resultSet);
            JdbcDeleteUtils.closeStatement(statement);
            JdbcDeleteUtils.closeConnection(connection);
        }
        return null;
    }

    public void delete(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("DELETE FROM school WHERE id=?");
            statement.setLong(1, id);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to delete data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcDeleteUtils.closeStatement(statement);
            JdbcDeleteUtils.closeConnection(connection);
        }
    }
}
