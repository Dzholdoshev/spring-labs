package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl.CART;

@Controller

public class ProductController {
public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/list")
    public String retrieveAllList(Model model){
        model.addAttribute("products", productService.listProduct());
        model.addAttribute("cartTotalAmount", CART.getCartTotalAmount());
        return "product/list";
    }




    @GetMapping("/create-form")
    public String getCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute ("product") Product product){
        productService.productCreate(product);
        return "redirect:/list";
    }







}
