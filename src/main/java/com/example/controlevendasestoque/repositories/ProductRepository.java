package com.example.controlevendasestoque.repositories;

import com.example.controlevendasestoque.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAllProducts() {
        return jdbcTemplate.query("SELECT * FROM products", (rs, rowNum) ->
                new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("quantity_available"),
                        rs.getBigDecimal("unit_price")
                ));
    }

    public Product saveProduct(Product product) {
        jdbcTemplate.update("INSERT INTO products (name, description, quantity_available, unit_price) VALUES (?, ?, ?, ?)",
                product.getName(), product.getDescription(), product.getQuantityAvailable(), product.getUnitPrice());
        return product;
    }

    public Product findProductById(Integer id) {
        List<Product> products = jdbcTemplate.query(
                "SELECT * FROM products WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("quantity_available"),
                        rs.getBigDecimal("unit_price")
                )
        );

        if (products.isEmpty()) {
            // Não encontrou nenhum produto com o ID especificado
            return null; // ou lançar uma exceção, se preferir
        } else {
            // Retorna o primeiro produto encontrado (assumindo que IDs são únicos)
            return products.get(0);
        }
    }

    public void updateProduct(Product product) {
        jdbcTemplate.update("UPDATE products SET name = ?, description = ?, quantity_available = ?, unit_price = ? WHERE id = ?",
                product.getName(), product.getDescription(), product.getQuantityAvailable(), product.getUnitPrice(), product.getId());
    }

    public void deleteProduct(Integer id) {
        jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }
}
