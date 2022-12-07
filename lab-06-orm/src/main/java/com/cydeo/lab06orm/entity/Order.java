package com.cydeo.lab06orm.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;



}
