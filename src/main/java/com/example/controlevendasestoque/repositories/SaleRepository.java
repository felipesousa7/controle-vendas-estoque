package com.example.controlevendasestoque.repositories;

import com.example.controlevendasestoque.model.ProductSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.controlevendasestoque.model.Sale;

import java.util.List;

@Repository
public class SaleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SaleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Sale> findAllSales() {
        return jdbcTemplate.query("SELECT * FROM sales", new BeanPropertyRowMapper<>(Sale.class));
    }

    public Sale saveSale(Sale sale) {
        // Inserir a venda na tabela 'sales' e obter o ID inserido
        Integer saleId = jdbcTemplate.queryForObject(
                "INSERT INTO sales (client, total_price) VALUES (?, ?) RETURNING id",
                Integer.class,
                sale.getClient(),
                sale.getTotalPrice()
        );

        // Inserir cada produto vendido na tabela 'sales_products'
        List<ProductSale> productsSold = sale.getProductsSold();
        if (productsSold != null && !productsSold.isEmpty()) {
            for (ProductSale soldItem : productsSold) {
                jdbcTemplate.update(
                        "INSERT INTO sales_products (sale_id, product_id, quantity) VALUES (?, ?, ?)",
                        saleId, soldItem.getProductId(), soldItem.getQuantitySold()
                );
            }
        }

        return sale;
    }




    @SuppressWarnings("deprecation")
    public Sale findSaleById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM sales WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Sale.class));
    }

    public void updateSale(Sale sale) {
        jdbcTemplate.update("UPDATE sales SET client = ?, total_price = ?, products = ? WHERE id = ?",
                sale.getClient(), sale.getTotalPrice(), sale.getProductsSold(), sale.getId());
    }

    public void deleteSale(Integer id) {
        jdbcTemplate.update("DELETE FROM sales WHERE id = ?", id);
    }
}
