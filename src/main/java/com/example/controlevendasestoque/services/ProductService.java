package com.example.controlevendasestoque.services;

import com.example.controlevendasestoque.model.Product;
import com.example.controlevendasestoque.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    public Product addProduct(Product product) {
        if (product.getQuantityAvailable() > 0) {
            return productRepository.saveProduct(product);
        } else {
            throw new IllegalArgumentException("A quantidade disponível deve ser maior que zero.");
        }
    }

    public Product getProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    public Product updateProduct(Integer id, Product product) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setQuantityAvailable(product.getQuantityAvailable());
            existingProduct.setUnitPrice(product.getUnitPrice());
            productRepository.updateProduct(existingProduct);
        }
        return existingProduct;
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }
}
