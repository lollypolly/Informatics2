package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private Connection connection;

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public void save(User entity) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.execute("insert into users (username, password) values ('" + entity.getUsername() + "','" + entity.getPassword() + "')");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public boolean validate(String username, String password) {
        try {
            Statement statement = connection.createStatement();

            return statement.executeQuery("select '" + username + "' from users where password = '" + password + "'").next();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return false;
        }
    }
}
