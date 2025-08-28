package com.example.ws.api;

import com.example.ws.domain.Product;
import com.example.ws.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {
    private final ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.loadAll();
    }
    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return productService.search(keyword);
    }

    @PostMapping
    public ResponseEntity<Product> addNew(@RequestBody Product product) {
        productService.insert(product);
        return ResponseEntity.status(201).body(product);
    }

}
