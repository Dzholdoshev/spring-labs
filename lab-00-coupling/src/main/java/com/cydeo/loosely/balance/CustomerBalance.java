package com.cydeo.loosely.balance;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@ToString

public class CustomerBalance extends Balance{

    public CustomerBalance(UUID userId, BigDecimal amount) {
        super(userId,amount);
    }


    public BigDecimal addBalance(BigDecimal amount) {
        setAmount(getAmount().add(amount));
        return getAmount();
    }
}
