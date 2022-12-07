package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.mapper.ProductMapper;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProduct() {

    }

    @Override
    public List<ProductDTO> getProductList() {
        return null;
    }

    @Override
    public List<ProductDTO> getTop3ProductList() {
        return null;
    }

    @Override
    public List<ProductDTO> getProductListByName(String name) {
        return null;
    }

    @Override
    public List<ProductDTO> getProductListByCategory() {
        return null;
    }

    @Override
    public List<ProductDTO> getProductListByPrice(BigDecimal price) {
        return null;
    }

    @Override
    public List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity) {
        return null;
    }
}
