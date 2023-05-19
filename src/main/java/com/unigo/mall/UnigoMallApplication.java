package com.unigo.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UnigoMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnigoMallApplication.class, args);
    }

}
