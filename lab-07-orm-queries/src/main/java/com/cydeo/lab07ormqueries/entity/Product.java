package com.cydeo.lab07ormqueries.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", remainingQuantity=" + remainingQuantity +
                ", categoryList=" + categoryList +
                '}'+"\n";
    }
}
