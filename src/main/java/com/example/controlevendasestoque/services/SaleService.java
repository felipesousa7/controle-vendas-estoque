package com.example.controlevendasestoque.services;

import com.example.controlevendasestoque.model.Product;
import com.example.controlevendasestoque.model.ProductSale;
import com.example.controlevendasestoque.model.Sale;
import com.example.controlevendasestoque.repositories.ProductRepository;
import com.example.controlevendasestoque.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAllSales();
    }

    public Sale addSale(Sale sale) {
        updateProductStock(sale); // Atualiza o estoque dos produtos

        return saleRepository.saveSale(sale); // Salva a venda no banco de dados
    }

    public Sale getSaleById(Integer id) {
        return saleRepository.findSaleById(id);
    }

    public void deleteSale(Integer id) {
        saleRepository.deleteSale(id);
    }

    private void updateProductStock(Sale sale) {
        for (ProductSale productSale : sale.getProductsSold()) {
            int soldQuantity = productSale.getQuantitySold();

            Product existingProduct = productRepository.findProductById(productSale.getProductId());
            if (existingProduct != null) {
                int newStock = existingProduct.getQuantityAvailable() - soldQuantity;
                existingProduct.setQuantityAvailable(newStock);
                productRepository.updateProduct(existingProduct);
            }
        }
    }


}
