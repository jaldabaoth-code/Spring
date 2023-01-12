package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcIntroduction;

import com.wildcodeschool.wildandwizard.entity.Person;
import com.wildcodeschool.wildandwizard.util.jdbc.jdbcIntroduction.JdbcIntroductionUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* Quest : JDBC Introduction */
public class JdbcIntroductionPersonRepository implements JdbcIntroductionCrudDao<Person> {
    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public void getDataParameters(String databaseUrl, String databaseUsername, String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
    }

    @Override
    public Person save(Person person) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement(
                    "INSERT INTO person (first_name, last_name, age) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                person.setId(id);
                return person;
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcIntroductionUtils.closeResultSet(generatedKeys);
            JdbcIntroductionUtils.closeStatement(statement);
            JdbcIntroductionUtils.closeConnection(connection);
        }
        return null;
    }

    @Override
    public Person findById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM person WHERE id = ?;");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                return new Person(id, firstName, lastName, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcIntroductionUtils.closeResultSet(resultSet);
            JdbcIntroductionUtils.closeStatement(statement);
            JdbcIntroductionUtils.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("SELECT * FROM person;");
            resultSet = statement.executeQuery();
            List<Person> persons = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                persons.add(new Person(id, firstName, lastName, age));
            }
            return persons;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcIntroductionUtils.closeResultSet(resultSet);
            JdbcIntroductionUtils.closeStatement(statement);
            JdbcIntroductionUtils.closeConnection(connection);
        }
        return null;
    }

    @Override
    public Person update(Person person) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("UPDATE person SET first_name=?, last_name=?, age=? WHERE id=?");
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());
            statement.setLong(4, person.getId());
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcIntroductionUtils.closeStatement(statement);
            JdbcIntroductionUtils.closeConnection(connection);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement("DELETE FROM person WHERE id=?");
            statement.setLong(1, id);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to delete data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcIntroductionUtils.closeStatement(statement);
            JdbcIntroductionUtils.closeConnection(connection);
        }
    }
}
