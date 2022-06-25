package by.it.academy.services;

import by.it.academy.entities.Product;
import by.it.academy.repositories.ProductRepository;
import by.it.academy.repositories.Repository;

import java.util.Collections;
import java.util.List;

public class ProductService {
    private final Repository<Product> productRepository = new ProductRepository();

    protected void create(Product product) {
        productRepository.create(product);
    }

    protected List<Product> getAll() {
        return productRepository.getAll().orElse(Collections.emptyList());
    }

    protected List<Product> getAvailable() {
        return ((ProductRepository)productRepository).getAvailable().orElse(Collections.emptyList());
    }

    protected void update(Product product) {
        productRepository.update(product);
    }

    protected void delete(Long id) {
        productRepository.delete(id);
    }

    protected void buy(Product product, int amount) {
        int newProductAmount = product.getAmount() - amount;
        product.setAmount(newProductAmount);
        productRepository.update(product);
    }
}