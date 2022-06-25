package by.it.academy.services;

import by.it.academy.entities.Order;
import by.it.academy.entities.Product;
import by.it.academy.entities.User;

import java.util.ArrayList;

public class OnlineStore {
    UserService userService = new UserService();
    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();


    public void createAccount(User user) {
        userService.create(user);
    }

    public User getUserByNameAndPassword(String login, String password) {
        return userService.getUserByNameAndPassword(login, password);
    }

    public ArrayList<Product> getAvailableProducts() {
        return (ArrayList<Product>) productService.getAvailable();
    }

    public void buyProduct(Product product, int amount) {
        productService.buy(product, amount);
    }

    public void createOrder(Order order) {
        orderService.create(order);
    }

    public ArrayList<Order> getAllOrders() {
        return (ArrayList<Order>) orderService.getAll();
    }

    public void modifyOrder(Order order) {
        orderService.update(order);
    }

    public void deleteOrder(Long id) {
        orderService.delete(id);
    }

    public void modifyProduct(Product product) {
        productService.update(product);
    }

    public void modifyUser(User user) {
        userService.update(user);
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userService.getAll();
    }

    public void createProduct(Product product) {
        productService.create(product);
    }

    public void deleteProduct(Long id) {
        productService.delete(id);
    }

    public void deleteUser(Long id){
        userService.delete(id);
    }

    public boolean isRegisteredUser(String login, String password) {
        return userService.isRegisteredUser(login, password);
    }
}