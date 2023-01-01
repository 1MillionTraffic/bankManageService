package com.onemillion.bankmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BankManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankManagerApplication.class, args);
    }

}
