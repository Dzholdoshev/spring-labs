package com.cydeo.lab06orm.entity;

import com.cydeo.lab06orm.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal paidPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

}
