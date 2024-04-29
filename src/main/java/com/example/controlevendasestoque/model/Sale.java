package com.example.controlevendasestoque.model;
import com.example.controlevendasestoque.model.ProductSale;

import java.math.BigDecimal;
import java.util.List;

public class Sale {
    private Integer id;
    private String client;
    private BigDecimal totalPrice;
    private List<ProductSale> productsSold; // Alteração: lista de produtos vendidos com suas quantidades

    public Sale() {
        // Default constructor
    }

    public Sale(Integer id, String client, BigDecimal totalPrice, List<ProductSale> productsSold) {
        this.id = id;
        this.client = client;
        this.totalPrice = totalPrice;
        this.productsSold = productsSold;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductSale> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(List<ProductSale> productsSold) {
        this.productsSold = productsSold;
    }
}
