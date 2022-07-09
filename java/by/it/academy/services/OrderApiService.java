package by.it.academy.services;

import by.it.academy.entities.Order;

import by.it.academy.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderApiService implements OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(Order order) {
        orderRepository.saveAndFlush(order);
    }

    public List<Order> getOrders() {
       return orderRepository.getAll().orElse(Collections.emptyList());
    }

    public void updateOrder(Order order) {
        orderRepository.saveAndFlush(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
