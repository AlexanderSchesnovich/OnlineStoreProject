package by.it.academy.controllers;

import by.it.academy.services.OnlineStore;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/delete")
public class DeleteProductController extends HttpServlet {

    private final OnlineStore onlineStore = new OnlineStore();
    private static final Logger log = Logger.getLogger(DeleteProductController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        Long id = Long.valueOf(req.getParameter("id"));
        onlineStore.deleteProduct(id);
        log.info("Product has been deleted with id: " + id);
    }
}