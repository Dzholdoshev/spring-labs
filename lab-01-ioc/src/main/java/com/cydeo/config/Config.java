package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

@Bean
  public Currency ccy (){
        return new Currency("ISO 1240", "EUR");
}

@Bean
    public Current currentAcct() {
    Current current = new Current();
    current.setAccountId(UUID.randomUUID());
    current.setAmount(new BigDecimal(500));
    current.setCurrency(new Currency("ISO 1240","USD"));
    return current;
}

@Bean
    public Saving savingAcct(Currency currency) {
      Saving saving = new Saving();
      saving.setAccountId(UUID.randomUUID());
      saving.setAmount(new BigDecimal(500));
      saving.setCurrency(ccy());
      return saving;
      }

    }




