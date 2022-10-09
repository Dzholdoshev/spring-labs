package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){

        Product product = productService.findProductById(productId);
        BigDecimal totalAmount = product.getPrice().multiply(BigDecimal.valueOf(quantity));
        CartItem cartItem = new CartItem(product,quantity,totalAmount);
        CART.getCartItemList().add(cartItem);
        CART.getCartTotalAmount().add(totalAmount);
        //todo retrieve product from repository method
        //todo initialise cart item
        //todo calculate cart total amount
        //todo add to cart
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        Product product = productService.findProductById(productId);

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(product.getPrice().multiply(BigDecimal.valueOf(product.getRemainingQuantity()))));
        return CART.getCartItemList().removeIf(cartItem ->
                cartItem.getProduct().getId().toString().
                        equals(productId.toString()));
    }

//    @Override
//    public List<CartItem> findAll() {
//        return CART.getCartItemList();
//    }


}
