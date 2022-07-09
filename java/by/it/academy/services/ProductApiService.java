package by.it.academy.services;

import by.it.academy.dtos.CreationProductRequest;
import by.it.academy.dtos.CreationUserRequest;
import by.it.academy.entities.Product;
import by.it.academy.entities.User;
import by.it.academy.entities.UserStatus;
import by.it.academy.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductApiService implements ProductService{
    private final ProductRepository productRepository;

    public void createProduct(CreationProductRequest request) {
        productRepository.save(buildProduct(request));
    }

    public List<Product> getProducts() {
        return productRepository.getAll().orElse(Collections.emptyList());
    }

    public List<Product> getAvailableProducts() {
        return productRepository.getAvailable().orElse(Collections.emptyList());
    }

    public void updateProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void buyProduct(Product product, int amount) {
        int newAmount = product.getAmount() - amount;
        product.setAmount(newAmount);
        productRepository.saveAndFlush(product);
    }

    public Product buildProduct(CreationProductRequest request){
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .amount(request.getAmount())
                .build();
        return product;
    }
}