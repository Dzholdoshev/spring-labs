package com.cydeo;

import com.cydeo.loosely.BalanceManager;
import com.cydeo.loosely.balance.CustomerBalance;
import com.cydeo.loosely.balance.GiftCardBalance;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UUID user = UUID.randomUUID();

        CustomerBalance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
        GiftCardBalance giftCardBalance = new GiftCardBalance(user, BigDecimal.ZERO);

        customerBalance.addBalance(new BigDecimal(150));
        giftCardBalance.addBalance(new BigDecimal(120));

        CustomerBalance customerBalance1 = new CustomerBalance(UUID.randomUUID(), BigDecimal.ZERO);
        GiftCardBalance giftCardBalance1 = new GiftCardBalance(UUID.randomUUID(), BigDecimal.ZERO);

        Boolean result = new BalanceManager().checkout(customerBalance,BigDecimal.valueOf(200));
        System.out.println(result);
        Boolean result1 = new BalanceManager().checkout(giftCardBalance,BigDecimal.valueOf(100));
        System.out.println(result1);


    }

}
