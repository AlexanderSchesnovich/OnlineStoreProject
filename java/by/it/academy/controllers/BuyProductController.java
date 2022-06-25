package by.it.academy.controllers;

import by.it.academy.entities.Product;

import by.it.academy.services.OnlineStore;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/buy")
public class BuyProductController extends HttpServlet {
    private final OnlineStore onlineStore = new OnlineStore();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = Product.builder()
                .name(req.getParameter("name"))
                .price(Integer.parseInt(req.getParameter("price")))
                .amount(Integer.parseInt(req.getParameter("amount")))
                .build();
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        onlineStore.buyProduct(product, quantity);
        getServletContext().getRequestDispatcher(PRODUCT_IS_BOUGHT_PATH).forward(req, resp);
    }
}