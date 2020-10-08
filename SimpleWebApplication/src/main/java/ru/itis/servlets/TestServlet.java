package ru.itis.servlets;

import ru.itis.database.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class TestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(DAO.dao.validate(username, pass));
        if(DAO.dao.validate(username, pass)){
            request.getRequestDispatcher("WEB-INF/profile.html").forward(request,response);
        } else {
            response.sendRedirect("/");
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("login.html").forward(request,response);

    }
}

