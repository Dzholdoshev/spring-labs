package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
   void createProduct(ProductDTO productDTO);
   void updateProduct(ProductDTO productDTO);
    List<ProductDTO> getProductList();
    List<ProductDTO> getTop3ProductList();
    ProductDTO getProductListByName(String name);
    List<ProductDTO> getProductListByCategory(Long categoryId);
    List<ProductDTO> getProductListByPrice(BigDecimal price);
    List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity);
    Integer findAllByPrice(BigDecimal price);
    Integer countProductByPriceGreaterThan(BigDecimal price);
    Integer countAllByPriceAndQuantity(BigDecimal price, Integer quantity);






}
