package com.cydeo.lab06orm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
