package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.util.jdbc.jdbcInsert.JdbcInsertUtils;
import java.sql.*;

/* Quest : JDBC Insert */
public class JdbcInsertSchoolRepository {

/*
    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public void getDataParameters(String databaseUrl, String databaseUsername, String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
    }
*/

    private final static String DB_URL = "";
    private final static String DB_USER = "";
    private final static String DB_PASSWORD = "";

    public School save(String name, Long capacity, String country) {
        System.out.println("titi");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            System.out.println("ruru1");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("ruru2");
            statement = connection.prepareStatement("INSERT INTO school (name, capacity, country) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            System.out.println("ruru3");
            statement.setString(1, name);
            statement.setLong(2, capacity);
            statement.setString(3, country);
            System.out.println("ruru4");
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }
            generatedKeys = statement.getGeneratedKeys();
            System.out.println("toto");
            System.out.println(generatedKeys);
            if (generatedKeys.next()) {
                System.out.println("titi");
                Long id = generatedKeys.getLong(1);
                System.out.println("tata");
                return new School(id, name, capacity, country);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            System.out.println("ruru5");
            e.printStackTrace();
        } finally {
            System.out.println("ruru6");
            JdbcInsertUtils.closeResultSet(generatedKeys);
            JdbcInsertUtils.closeStatement(statement);
            JdbcInsertUtils.closeConnection(connection);
        }
        return null;
    }
}
