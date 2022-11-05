package com.cydeo.lab06orm.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private Integer remainingQuantity;

    @ManyToMany
    @JoinTable(name="product_category_rel",
            joinColumns = {@JoinColumn(name = "p_id")},
    inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Category> categoryList;


}
