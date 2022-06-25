package by.it.academy.controllers;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;
import by.it.academy.services.OnlineStore;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create_account")
public class RegistrationController extends HttpServlet {

    private final OnlineStore onlineStore = new OnlineStore();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final UserType userType = UserType.valueOf(req.getParameter("userType"));
        User user = User.builder()
                .login(login)
                .password(password)
                .userType(userType)
                .build();
        onlineStore.createAccount(user);
    }
}
