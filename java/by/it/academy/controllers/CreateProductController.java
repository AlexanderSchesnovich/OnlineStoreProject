package by.it.academy.controllers;

import by.it.academy.entities.Product;
import by.it.academy.services.OnlineStore;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/create")
public class CreateProductController extends HttpServlet {
    private final OnlineStore storeService = new OnlineStore();
    private static final Logger log = Logger.getLogger(CreateProductController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Product product = Product.builder()
                .name(req.getParameter("name"))
                .price(Integer.parseInt(req.getParameter("price")))
                .amount(Integer.parseInt(req.getParameter("amount")))
                .build();
        storeService.createProduct(product);
        log.info("Has been added: " + product);
    }
}
