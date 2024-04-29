package com.example.controlevendasestoque.model;

public class ProductSale {
    private Integer productId;
    private int quantitySold;

    public ProductSale(Integer productId, int quantitySold) {
        this.productId = productId;
        this.quantitySold = quantitySold;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
}
