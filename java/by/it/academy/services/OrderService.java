package by.it.academy.services;

import by.it.academy.entities.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);
    List<Order> getOrders();
    void updateOrder(Order order);
    void deleteOrder(Long id);
}
