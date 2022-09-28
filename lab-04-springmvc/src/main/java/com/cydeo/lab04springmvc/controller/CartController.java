package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {

    private final CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cart-list")
    public String listCarts(Model model){
    model.addAttribute("cartList",cartService.retrieveCartList());


    return "cart/cart-list";
}

@RequestMapping("cart-detail/{cartID}")
    public String retrieveListOfCartDetails(@PathVariable UUID cartID,Model model){

        model.addAttribute("cartItemList", cartService. retrieveCartDetail(cartID));
        return "cart/cart-detail";
}
}
