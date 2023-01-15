package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.util.jdbc.jdbcInsert.JdbcInsertUtils;
import java.sql.*;

/* Quest : JDBC Insert */
public class JdbcInsertSchoolRepository {
    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public void getDataParameters(String databaseUrl, String databaseUsername, String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
    }

    public School save(String name, Long capacity, String country) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("INSERT INTO school (name, capacity, country) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setLong(2, capacity);
            statement.setString(3, country);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("Failed to insert data");
            }
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new School(id, name, capacity, country);
            } else {
                throw new SQLException("Failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcInsertUtils.closeResultSet(generatedKeys);
            JdbcInsertUtils.closeStatement(statement);
            JdbcInsertUtils.closeConnection(connection);
        }
        return null;
    }
}
