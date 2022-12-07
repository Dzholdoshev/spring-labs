package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
   void createProduct();
   void updateProduct();
    List<ProductDTO> getProductList();
    List<ProductDTO> getTop3ProductList();
    List<ProductDTO> getProductListByName(String name);
    List<ProductDTO> getProductListByCategory();
    List<ProductDTO> getProductListByPrice(BigDecimal price);
    List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity);








}
