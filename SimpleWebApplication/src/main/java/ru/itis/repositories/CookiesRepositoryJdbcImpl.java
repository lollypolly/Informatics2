package ru.itis.repositories;

import ru.itis.models.User;

import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CookiesRepositoryJdbcImpl implements CookiesRepository{

    private Connection connection;

    public CookiesRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Cookie entity) {

    }


    @Override
    public List<Cookie> findAll() {
        return null;
    }

    @Override
    public void save(Cookie entity, int user_id) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.execute("insert into uuid (uuid, user_id(FK))) values ('" + entity.getValue() + "','" + user_id + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
