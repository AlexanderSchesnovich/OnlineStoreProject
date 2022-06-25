package by.it.academy.controllers;

import by.it.academy.services.OnlineStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products")
public class DisplayProductsController extends HttpServlet {
    private final OnlineStore onlineStore = new OnlineStore();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("products", onlineStore.getAvailableProducts());
        getServletContext().getRequestDispatcher("/views/productMenuPage.jsp").forward(req, resp);
    }
}
