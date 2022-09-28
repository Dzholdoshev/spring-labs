package com.cydeo.config;

import com.cydeo.repository.CartRepository;
import com.cydeo.repository.CartRepositoryImpl;
import com.cydeo.service.StockService;
import com.cydeo.service.StockServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan ("com.cydeo")
public class ConfigApp {


}
