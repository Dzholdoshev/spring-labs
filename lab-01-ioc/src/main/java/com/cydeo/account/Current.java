package com.cydeo.account;

import com.cydeo.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@ToString

public class Current {
    private Currency currency;
    private BigDecimal amount;
    private UUID accountId;

    public void initialize(){
        System.out.println("current account " + " currency: "+ currency.getCode() + " amount: " + amount + "accountId" + accountId);
    }
}