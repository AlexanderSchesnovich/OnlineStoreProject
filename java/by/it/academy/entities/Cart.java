package by.it.academy.entities;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addItem(Product product) {
        products.add(product);
    }

    public void removeItem(Product product) {
        products.remove(product);
    }

    public static Cart getInstance(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart.equals(null)) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}