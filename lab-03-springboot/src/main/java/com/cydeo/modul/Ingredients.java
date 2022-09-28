package com.cydeo.modul;

import com.cydeo.enums.QuantityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Ingredients {
 private    String name;
 private   Integer quantity;
 private QuantityType quantityType;

}
