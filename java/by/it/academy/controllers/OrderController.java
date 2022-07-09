package by.it.academy.controllers;

import by.it.academy.entities.Order;
import by.it.academy.services.OnlineStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OnlineStore store;

    @PostMapping(value = "/orders",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Order order) {
        store.createOrder(order);
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> getOrders() {
        final List<Order> orders = store.getOrders();
        return orders.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @DeleteMapping(value = "/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(name = "id") Long id) {
        store.deleteOrder(id);
    }

    @PutMapping(value = "/orders")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Order order) {
        store.updateOrder(order);
    }
}
