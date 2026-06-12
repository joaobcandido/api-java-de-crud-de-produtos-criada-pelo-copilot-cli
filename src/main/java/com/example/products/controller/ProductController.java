package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Product> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Optional<Product> p = repo.findById(id);
        return p.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product create(@RequestBody Product product) { return repo.save(product); }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return repo.findById(id).map(existing -> {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            return ResponseEntity.ok(repo.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
