package com.cydeo.lab07ormqueries.entity;


import com.cydeo.lab07ormqueries.enums.CartState;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CartState cartState;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Override
    public String toString() {
        return "Cart{" +
                "cartState=" + cartState +
                ", customer=" + customer +
                ", discount=" + discount +
                '}'+"\n";
    }
}
