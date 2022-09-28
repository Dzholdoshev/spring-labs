package com.cydeo.service;

import com.cydeo.model.Product;
import com.cydeo.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class StockServiceImpl implements StockService{



    @Override
    public boolean checkStockIsAvailable(Product product, int quantity) {
        return product.getRemainingQuantity() > quantity;
    }
}
