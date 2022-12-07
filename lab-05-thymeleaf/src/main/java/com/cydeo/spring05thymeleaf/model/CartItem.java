package com.cydeo.spring05thymeleaf.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter


public class CartItem {
    private Product product;
    private Integer quantity;
    private BigDecimal totalAmount;

    public CartItem(Product product, Integer quantity, BigDecimal totalAmount) {
        this.product = product;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
}
