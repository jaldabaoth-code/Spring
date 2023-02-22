package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcCrud;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.util.jdbc.jdbcCrud.JdbcCrudUtils;
import org.springframework.jdbc.support.JdbcUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCrudWizardRepository implements JdbcCrudCrudDao<Wizard> {

    private static String databaseUrl;
    private static String databaseUsername;
    private static String databasePassword;

    public void getDataParameters(String databaseUrl, String databaseUsername, String databasePassword) {
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
    }

    @Override
    public Wizard save(Wizard wizard) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement(
            		"INSERT INTO wizard (first_name, last_name, birthday, birth_place, biography, is_muggle) VALUES (?, ?, ?, ?, ?, ?)",
            		Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, wizard.getFirstName());
            statement.setString(2, wizard.getLastName());
            statement.setDate(3, wizard.getBirthday());
            statement.setString(4, wizard.getBirthPlace());
            statement.setString(5, wizard.getBiography());
            statement.setBoolean(6, wizard.isMuggle());

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                wizard.setId(id);
                return wizard;
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
		} finally {
			JdbcUtils.closeResultSet(generatedKeys);
			JdbcUtils.closeStatement(statement);
			JdbcUtils.closeConnection(connection);
		}
        return null;
    }

    @Override
    public Wizard findById(Long id) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement(
                    "SELECT * FROM wizard WHERE id = ?;"
            );
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date birthday = resultSet.getDate("birthday");
                String birthPlace = resultSet.getString("birth_place");
                String biography = resultSet.getString("biography");
                boolean muggle = resultSet.getBoolean("is_muggle");
                return new Wizard(id, firstName, lastName, birthday, birthPlace, biography, muggle);
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

    @Override
    public List<Wizard> findAll() {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement(
                    "SELECT * FROM wizard;"
            );
            resultSet = statement.executeQuery();

            List<Wizard> wizards = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date birthday = resultSet.getDate("birthday");
                String birthPlace = resultSet.getString("birth_place");
                String biography = resultSet.getString("biography");
                boolean muggle = resultSet.getBoolean("is_muggle");
                wizards.add(new Wizard(id, firstName, lastName, birthday, birthPlace, biography, muggle));
            }
            return wizards;
        } catch (SQLException e) {
            e.printStackTrace();
		} finally {
			JdbcUtils.closeResultSet(resultSet);
			JdbcUtils.closeStatement(statement);
			JdbcUtils.closeConnection(connection);
		}
        return null;
    }

    @Override
    public Wizard update(Wizard wizard) {
		Connection connection = null;
		PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement(
                    "UPDATE wizard SET first_name=?, last_name=?, birthday=?, birth_place=?, biography=?, is_muggle=? WHERE id=?"
            );
            statement.setString(1, wizard.getFirstName());
            statement.setString(2, wizard.getLastName());
            statement.setDate(3, wizard.getBirthday());
            statement.setString(4, wizard.getBirthPlace());
            statement.setString(5, wizard.getBiography());
            statement.setBoolean(6, wizard.isMuggle());
            statement.setLong(7, wizard.getId());

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return wizard;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		finally {
			JdbcUtils.closeStatement(statement);
			JdbcUtils.closeConnection(connection);
		}
        return null;
    }

    @Override
    public void deleteById(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            statement = connection.prepareStatement(
                    "DELETE FROM wizard WHERE id=?"
            );
            statement.setLong(1, id);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to delete data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		finally {
			JdbcUtils.closeStatement(statement);
			JdbcUtils.closeConnection(connection);
		}
    }
}
