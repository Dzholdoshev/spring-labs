package com.cydeo.lab07ormqueries.entity;


import com.cydeo.lab07ormqueries.enums.DiscountType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Discount {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Double discount;
   @Enumerated(EnumType.STRING)
   private DiscountType discountType;
   private String name;


   @Override
   public String toString() {
      return "Discount{" +
              "discount=" + discount +
              ", discountType=" + discountType +
              ", name='" + name + '\'' +
              '}'+"\n";
   }
}
