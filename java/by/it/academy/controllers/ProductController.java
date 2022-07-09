package by.it.academy.controllers;

import by.it.academy.dtos.CreationProductRequest;
import by.it.academy.entities.Product;
import by.it.academy.services.OnlineStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final OnlineStore store;

    @PostMapping(value = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid CreationProductRequest request) {
        store.createProduct(request);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAvailableProducts() {
        final List<Product> products = store.getAvailableProducts();
        return products.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping(value = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        store.deleteProduct(id);
    }

    @PutMapping(value = "/products")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody Product product) {
        store.updateProduct(product);
    }

    @PutMapping(value = "/products/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void buyProduct(@RequestBody Product product, @PathVariable(name = "amount") int amount) {
        store.buyProduct(product, amount);
    }
}
