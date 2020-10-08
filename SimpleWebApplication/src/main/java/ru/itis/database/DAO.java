package ru.itis.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DAO {
    public static DAO dao;

    private Properties property;
    String db_host, db_login, db_password;

    static {
        dao = new DAO();
    }

    private DAO() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\pc\\IdeaProjects\\SimpleWebApplication\\src\\main\\resources\\DB.properties");
            property = new Properties();
            property.load(fis);

            db_host = property.getProperty("host");
            db_login = property.getProperty("login");
            db_password = property.getProperty("password");
        } catch (IOException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
        }
    }

    public boolean validate(Object username, Object password) {//проверяет логин и пароль
        final String db_host = property.getProperty("host");
        final String db_login = property.getProperty("login");
        final String db_password = property.getProperty("password");

        try {
            Connection connection = DriverManager.getConnection(db_host, db_login, db_password);
            Statement statement = connection.createStatement();
            Class.forName("org.postgresql.Driver");

            return statement.executeQuery("select '" + username + "' from users where password = '" + password + "'").next();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return false;
        }
    }

    public boolean add(Object username, Object password) { //добавляет в бд
        try {
            Connection connection = DriverManager.getConnection(db_host, db_login, db_password);
            Statement statement = connection.createStatement();
            Class.forName("org.postgresql.Driver");

            return statement.execute("insert into users (username, password) values ('" + username + "','" + password + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return false;
        }
    }

    public String find() {
        try {
            Connection connection = DriverManager.getConnection(db_host, db_login, db_password);
            Statement statement = connection.createStatement();
            Class.forName("org.postgresql.Driver");
            StringBuilder result = new StringBuilder();
            ResultSet query = statement.executeQuery("select * from users");
            while(query.next()){
                result.append(query.getString("username")).append("\n");
            }
            return result.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return null;

        }
    }
}