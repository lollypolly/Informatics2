package ru.itis.servlets;

import ru.itis.dto.SignUpForm;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
import ru.itis.services.SignUpService;
import ru.itis.services.SignUpServiceImpl;
import ru.itis.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {


    private SignUpService signUpService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        signUpService = (SignUpService) config.getServletContext().getAttribute("signUpService");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SignUpForm form = new SignUpForm();
        form.setFirstName(request.getParameter("firstName"));
        form.setLastName(request.getParameter("lastName"));
        form.setEmail(request.getParameter("email"));
        form.setPassword(request.getParameter("password"));

        signUpService.signUp(form);

        response.sendRedirect("/signIn");
    }
}

