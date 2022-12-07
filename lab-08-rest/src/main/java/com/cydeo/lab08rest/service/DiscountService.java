package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {
    List<DiscountDTO> getDiscountList();

    DiscountDTO getDiscountByName(String name);

    void createDiscount(DiscountDTO discountDTO);

    void updateDiscount(DiscountDTO discountDTO);


}
