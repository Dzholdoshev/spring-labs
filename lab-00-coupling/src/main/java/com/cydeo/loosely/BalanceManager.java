package com.cydeo.loosely;

import com.cydeo.loosely.balance.Balance;
import com.cydeo.loosely.balance.CustomerBalance;
import com.cydeo.loosely.balance.GiftCardBalance;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public class BalanceManager {

    public  boolean checkout(Balance balance, BigDecimal amount)
       { BigDecimal balanceAmount = balance.getAmount();
           return  balanceAmount.subtract(amount)
        .compareTo(BigDecimal.ZERO)>0;
    }

}
