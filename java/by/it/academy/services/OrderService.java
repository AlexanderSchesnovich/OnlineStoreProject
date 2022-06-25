package by.it.academy.services;

import by.it.academy.entities.Order;
import by.it.academy.repositories.OrderRepository;
import by.it.academy.repositories.Repository;

import java.util.Collections;
import java.util.List;

public class OrderService {

    private final Repository<Order> orderRepository = new OrderRepository();

    protected void create(Order order) {
        orderRepository.create(order);
    }

    protected List<Order> getAll() {
        return orderRepository.getAll().orElse(Collections.emptyList());
    }

    protected void update(Order order) {
        orderRepository.update(order);
    }

    protected void delete(Long id) {
        orderRepository.delete(id);
    }
}
