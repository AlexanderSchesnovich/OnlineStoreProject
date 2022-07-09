package by.it.academy.repositories;

import by.it.academy.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT p FROM products p")
    Optional<List<Product>> getAll();


    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT p FROM products p WHERE p.amount > 0")
    Optional<List<Product>> getAvailable();
}