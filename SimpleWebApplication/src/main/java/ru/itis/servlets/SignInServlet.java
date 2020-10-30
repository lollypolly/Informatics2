package ru.itis.servlets;

import ru.itis.database.DAO;
import ru.itis.repositories.CookiesRepositoryJdbcImpl;
import ru.itis.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

//signin
@WebServlet("/login")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        //System.out.println(DAO.dao.validate(username, pass));
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp", "postgres", "fioletovobu27");
            UsersRepositoryJdbcImpl usersRepositoryJdbc = new UsersRepositoryJdbcImpl(connection);
            if (usersRepositoryJdbc.validate(username, pass)) {
                UUID uuid = UUID.randomUUID();
                CookiesRepositoryJdbcImpl cookiesRepositoryJdbc = new CookiesRepositoryJdbcImpl(connection);
                response.addCookie(new Cookie("Auth", uuid.toString()));
                connection.close();
                request.getRequestDispatcher("WEB-INF/profile.html").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.html").forward(request, response);

    }
}

