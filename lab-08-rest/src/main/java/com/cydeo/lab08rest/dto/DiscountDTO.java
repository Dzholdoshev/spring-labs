package com.cydeo.lab08rest.dto;

import com.cydeo.lab08rest.enums.DiscountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
//@JsonIgnoreProperties(value = {"","", ""},ignoreUnknown = true)
public class DiscountDTO{
    private String name;
    private BigDecimal discount;
    private DiscountType discountType;
    private Long id;
}
