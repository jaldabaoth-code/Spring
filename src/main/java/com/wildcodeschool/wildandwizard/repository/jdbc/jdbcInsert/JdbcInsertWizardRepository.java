package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.util.jdbc.jdbcInsert.JdbcInsertUtils;
import java.sql.*;

/* Quest : JDBC Insert */
public class JdbcInsertWizardRepository {
    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public void getDataParameters(String databaseUrl, String databaseUsername, String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
    }

    public Wizard save(String firstName, String lastName, Date birthday, String birthPlace, String biography, boolean muggle) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement(
                    "INSERT INTO wizard (first_name, last_name, birthday, birth_place, biography, muggle) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setDate(3, birthday);
            statement.setString(4, birthPlace);
            statement.setString(5, biography);
            statement.setBoolean(6, muggle);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new Wizard(id, firstName, lastName, birthday,
                        birthPlace, biography, muggle);
            } else {
                throw new SQLException("failed to get inserted id");
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
