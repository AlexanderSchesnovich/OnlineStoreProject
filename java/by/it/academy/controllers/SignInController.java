package by.it.academy.controllers;

import by.it.academy.entities.User;
import by.it.academy.services.OnlineStore;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/signIn")
public class SignInController extends HttpServlet {
    private final OnlineStore storeService = new OnlineStore();
    private static final Logger log = Logger.getLogger(SignInController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher;
        if (storeService.isRegisteredUser(login, password)) {
            User user = storeService.getUserByNameAndPassword(login,password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            log.info("User signed in: " + user);
            doPost(req, resp);
        } else {
            requestDispatcher = servletContext.getRequestDispatcher(LOGIN_ERROR_PATH);
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher;
        requestDispatcher = servletContext.getRequestDispatcher("/products");
        requestDispatcher.forward(req, resp);
    }
}
