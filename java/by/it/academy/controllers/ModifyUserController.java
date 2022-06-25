package by.it.academy.controllers;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;
import by.it.academy.services.OnlineStore;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/modify")
public class ModifyUserController extends HttpServlet {
    private final OnlineStore storeService = new OnlineStore();
    private static final Logger log = Logger.getLogger(ModifyUserController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserType userType = UserType.valueOf(req.getParameter("userType"));
        User user = User.builder()
                .login(login)
                .password(password)
                .userType(userType)
                .build();
        log.info("User has been modified: " + user);
        storeService.modifyUser(user);
    }
}
