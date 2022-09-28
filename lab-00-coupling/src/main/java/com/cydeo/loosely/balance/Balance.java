package com.cydeo.loosely.balance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Balance {
    private UUID userId;
    private BigDecimal amount;

    public abstract BigDecimal addBalance(BigDecimal amount) ;

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                '}';
    }
}
