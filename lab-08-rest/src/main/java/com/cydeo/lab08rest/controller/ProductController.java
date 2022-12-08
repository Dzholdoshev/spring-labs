package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.ProductMapper;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.ok(new ResponseWrapper("Product is created", productDTO, HttpStatus.OK));
    };
    @PutMapping
    ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.ok(new ResponseWrapper("Product is updated", productDTO, HttpStatus.OK));
    };
    @GetMapping
    ResponseEntity<ResponseWrapper>  getProductList(){
        List<ProductDTO> productDTOList = productService.getProductList();
        return ResponseEntity.ok(new ResponseWrapper("Product list is retrieved", productDTOList, HttpStatus.OK));
    };
    @GetMapping("/top3")
    ResponseEntity<ResponseWrapper>  getTop3ProductList(){
        List<ProductDTO> productDTOList = productService.getTop3ProductList();
        return ResponseEntity.ok(new ResponseWrapper("Top 3 Product list is retrieved", productDTOList, HttpStatus.OK));
    };
    @GetMapping("/{name}")
    ResponseEntity<ResponseWrapper>  getProductListByName(@PathVariable ("name") String name){
        ProductDTO productDTO = productService.getProductListByName(name);
        return ResponseEntity.ok(new ResponseWrapper("Product list by Name", productDTO, HttpStatus.OK));
    }
    @GetMapping("/category/{id}")
    ResponseEntity<ResponseWrapper>  getProductListByCategory(@PathVariable ("id") Long categoryId){
        List<ProductDTO> productDTOList = productService.getProductListByCategory(categoryId);
        return ResponseEntity.ok(new ResponseWrapper("Product list by category id", productDTOList, HttpStatus.OK));
    };
//    @GetMapping("/price/{price}")
//    ResponseEntity<ResponseWrapper>  getProductListByPrice(@PathVariable ("price") BigDecimal price){
//        List<ProductDTO> productDTOList = productService.getProductListByPrice(price);
//        return ResponseEntity.ok(new ResponseWrapper("Product list by price", productDTOList, HttpStatus.OK));
//    }

    @GetMapping("/price/{price}")
    ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable ("price") BigDecimal price){
        Integer result =  productService.findAllByPrice(price);
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",result ,HttpStatus.OK));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    ResponseEntity<ResponseWrapper>  getProductListByPriceAndQuantity(@PathVariable ("price") BigDecimal price, @PathVariable("quantity")  Integer quantity){
        Integer result = productService.countAllByPriceAndQuantity(price,quantity);
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved", result, HttpStatus.OK));
    };





}
