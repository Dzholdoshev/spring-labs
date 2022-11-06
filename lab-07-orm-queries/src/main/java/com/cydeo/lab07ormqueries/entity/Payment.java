package com.cydeo.lab07ormqueries.entity;


import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double paidPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

}
