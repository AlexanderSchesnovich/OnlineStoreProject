package by.it.academy.services;

import by.it.academy.dtos.CreationProductRequest;
import by.it.academy.entities.Product;

import java.util.List;

public interface ProductService {
    void createProduct(CreationProductRequest request);
    List<Product> getProducts();
    List<Product> getAvailableProducts();
    void updateProduct(Product product);
    void buyProduct(Product product, int amount);
    void deleteProduct(Long id);
}
