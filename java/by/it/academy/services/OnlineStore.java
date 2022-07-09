package by.it.academy.services;

import by.it.academy.dtos.CreationProductRequest;
import by.it.academy.dtos.CreationUserRequest;
import by.it.academy.entities.Order;
import by.it.academy.entities.Product;
import by.it.academy.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OnlineStore {

    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    public void createUser(CreationUserRequest request) {
        userService.createUser(request);
    }

    public Optional<User> getUserByLogin(String login) {
        return userService.getUserByLogin(login);
    }

    public ArrayList<Product> getAvailableProducts() {
        return (ArrayList<Product>) productService.getAvailableProducts();
    }

    public void buyProduct(Product product, int amount) {
        productService.buyProduct(product, amount);
    }

    public void createOrder(Order order) {
        orderService.createOrder(order);
    }

    public ArrayList<Order> getOrders() {
        return (ArrayList<Order>) orderService.getOrders();
    }

    public void updateOrder(Order order) {
        orderService.updateOrder(order);
    }

    public void deleteOrder(Long id) {
        orderService.deleteOrder(id);
    }

    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }

    public void updateUser(User user) {
        userService.updateUser(user);
    }

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userService.getUsers();
    }

    public void createProduct(CreationProductRequest request) {
        productService.createProduct(request);
    }

    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }

    public void deleteUser(Long id){
        userService.deleteUser(id);
    }
}