package by.it.academy.repositories;

import by.it.academy.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {
    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT o FROM orders o")
    Optional<List<Order>> getAll();
}