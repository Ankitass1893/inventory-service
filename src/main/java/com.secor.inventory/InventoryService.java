package com.secor.inventory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository productRepository;

    public InventoryService(InventoryRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Inventory> getAllProducts() {
        return (List<Inventory>) productRepository.findAll();
    }

    public Inventory getProductById(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Inventory createProduct(Inventory product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
