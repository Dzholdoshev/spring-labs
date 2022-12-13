package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.mapper.DiscountMapper;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;
    private final DiscountMapper discountMapper;

    public DiscountController(DiscountService discountService, DiscountMapper discountMapper) {
        this.discountService = discountService;
        this.discountMapper = discountMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getDiscountList(){

        List<DiscountDTO> discountDTOList = discountService.getDiscountList();
        return ResponseEntity.ok(new ResponseWrapper("List of Discounts is retrieved",
                discountDTOList,
                HttpStatus.OK));
    };
    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getDiscountListByName(@PathVariable ("name") String name){
        DiscountDTO discountDTO = discountService.getDiscountByName(name);
        return ResponseEntity.ok(new ResponseWrapper("List of Discounts by Name", discountDTO, HttpStatus.OK));
    };

    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO){
        discountService.createDiscount(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount is created", discountDTO, HttpStatus.OK));
    }

    @PutMapping
     public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO){
        discountService.updateDiscount(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount is updated", discountDTO, HttpStatus.OK));
    }




}
