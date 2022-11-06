package com.cydeo.lab07ormqueries.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Double paidPrice;
    private Double totalPrice;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Override
    public String toString() {
        return "Order{" +
                "paidPrice=" + paidPrice +
                ", totalPrice=" + totalPrice +
                ", cart=" + cart +
                ", customer=" + customer +
                ", payment=" + payment +
                '}'+"\n";
    }
}
