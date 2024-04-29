package com.example.controlevendasestoque.controllers;
import com.example.controlevendasestoque.services.SaleService;
import com.example.controlevendasestoque.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleService.getAllSales();
        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
        Sale newSale = saleService.addSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSale);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Integer id) {
        Sale sale = saleService.getSaleById(id);
        return ResponseEntity.ok(sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Integer id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
