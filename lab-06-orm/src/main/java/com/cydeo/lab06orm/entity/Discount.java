package com.cydeo.lab06orm.entity;

import com.cydeo.lab06orm.enums.DiscountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Discount {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private BigDecimal discount;
   @Enumerated(EnumType.STRING)
   private DiscountType discountType;
   private String name;




}
