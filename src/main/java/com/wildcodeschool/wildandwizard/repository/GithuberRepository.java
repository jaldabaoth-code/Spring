package com.wildcodeschool.wildandwizard.repository;

import com.wildcodeschool.wildandwizard.entity.Githuber;
import com.wildcodeschool.wildandwizard.util.JdbcUtils;
import com.wildcodeschool.wildandwizard.util.testService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GithuberRepository implements JDBCGithuberDAO<Githuber> {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/githubtracker?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";
    @Override
    public Githuber save(Githuber githuber) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "INSERT INTO githuber (github_id, name, login, url, email, bio, location, avatar_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setLong(1, githuber.getGithubId());
            statement.setString(2, githuber.getName());
            statement.setString(3, githuber.getLogin());
            statement.setString(4, githuber.getUrl());
            statement.setString(5, githuber.getEmail());
            statement.setString(6, githuber.getBio());
            statement.setString(7, githuber.getLocation());
            statement.setString(8, githuber.getAvatarUrl());

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                githuber.setId(id);
                return githuber;
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
    public Githuber findById(Long id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM githuber WHERE id = ?;"
            );
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Long githubId = resultSet.getLong("github_id");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String url = resultSet.getString("url");
                String email = resultSet.getString("email");
                String bio = resultSet.getString("bio");
                String location = resultSet.getString("location");
                String avatarUrl = resultSet.getString("avatar_url");
                return new Githuber(id, githubId, name, login, url, email, bio, location, avatarUrl);
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
    public List<Githuber> findAll() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM githuber;"
            );
            resultSet = statement.executeQuery();

            List<Githuber> githubers = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long githubId = resultSet.getLong("github_id");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String url = resultSet.getString("url");
                String email = resultSet.getString("email");
                String bio = resultSet.getString("bio");
                String location = resultSet.getString("location");
                String avatarUrl = resultSet.getString("avatar_url");
                githubers.add(new Githuber(id, githubId, name, login, url, email, bio, location, avatarUrl));
            }
            return githubers;
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
    public Githuber update(Githuber githuber) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "UPDATE githuber SET github_id=?, name=?, login=?, url=?, email=?, bio=?, location=?, avatar_url=? WHERE id=?"
            );
            statement.setLong(1, githuber.getGithubId());
            statement.setString(2, githuber.getName());
            statement.setString(3, githuber.getLogin());
            statement.setString(4, githuber.getUrl());
            statement.setString(5, githuber.getEmail());
            statement.setString(6, githuber.getBio());
            statement.setString(7, githuber.getLocation());
            statement.setString(8, githuber.getAvatarUrl());
            statement.setLong(9, githuber.getId());

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return githuber;
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
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "DELETE FROM githuber WHERE id=?"
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
