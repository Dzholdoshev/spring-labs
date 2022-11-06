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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categoryList")
    private List<Product> productList;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                '}'+"\n";
    }
}
