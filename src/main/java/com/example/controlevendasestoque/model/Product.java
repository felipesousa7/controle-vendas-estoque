package com.example.controlevendasestoque.model;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private Integer quantityAvailable;
    private BigDecimal unitPrice;

    public Product() {
        // Default constructor
    }

    public Product(Integer id, String name, String description, Integer quantityAvailable, BigDecimal unitPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
        this.unitPrice = unitPrice;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}