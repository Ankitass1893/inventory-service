package com.secor.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService productService;

    public InventoryController(InventoryService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Inventory> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Inventory getProductById(@PathVariable Long id) throws ResourceNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Inventory> createProduct(@RequestBody Inventory product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
