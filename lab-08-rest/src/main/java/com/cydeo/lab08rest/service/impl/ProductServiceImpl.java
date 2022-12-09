package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.mapper.ProductMapper;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.mapperUtil = mapperUtil;
    }



    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.convertToEntity(productDTO));
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = productRepository.save(mapperUtil.convert(productDTO, new Product()));
        return mapperUtil.convert(product, new ProductDTO());
    }

    @Override
    public List<ProductDTO> getProductList() {
       List<Product> productList=  productRepository.findAll();
        return productList.stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getTop3ProductList() {
        List<Product> productList=  productRepository.findTop3ByOrderByPriceDesc();
        return productList.stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductListByName(String name) {
        Product product=  productRepository.findFirstByName(name);
        return productMapper.convertToDto(product);
    }

    @Override
    public List<ProductDTO> getProductListByCategory(Long categoryId) {
        List<Product> productList=  productRepository.retrieveProductListByCategory(categoryId);
        return productList.stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductListByPrice(BigDecimal price) {
        List<Product> productList=  productRepository.getAllByPrice(price);
        return productList.stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductListByPriceAndQuantity(BigDecimal price, Integer quantity) {
        List<Product> productList=  productRepository.getAllByPriceAndQuantity(price,quantity);
        return productList.stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer findAllByPrice(BigDecimal price) {
        Integer result = productRepository.countProductByPriceGreaterThan(price);
        System.out.println("This is Sparta"+result);
        return result;
    }

    @Override
    public Integer countProductByPriceGreaterThan(BigDecimal price) {
        Integer result = productRepository.countProductByPriceGreaterThan(price);
        return result;
    }

    @Override
    public Integer countAllByPriceAndQuantity(BigDecimal price, Integer quantity) {
        Integer result = productRepository.countAllByPriceAndQuantity(price,quantity);
        return result;
    }

    @Override
    public List<ProductDTO> retrieveProductByCategoryAndPrice(List<Long> categoryList, BigDecimal price) {
        return productRepository.retrieveProductListByCategory(categoryList,price).stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }


}
