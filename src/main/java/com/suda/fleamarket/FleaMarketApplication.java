package com.suda.fleamarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class FleaMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(FleaMarketApplication.class, args);
    }

}
