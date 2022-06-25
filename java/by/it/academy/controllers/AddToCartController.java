package by.it.academy.controllers;

import by.it.academy.entities.Cart;
import by.it.academy.entities.Product;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/add_to_cart")
public class AddToCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Cart bean = Cart.getInstance(session);
        Product product = Product.builder()
                .name(req.getParameter("name"))
                .price(Integer.parseInt(req.getParameter("price")))
                .amount(Integer.parseInt(req.getParameter("amount")))
                .build();
        bean.addItem(product);
        resp.sendRedirect(CART_PAGE_PATH);
    }
}