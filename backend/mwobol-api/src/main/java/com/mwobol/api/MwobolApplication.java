package com.mwobol.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mwobol")
public class MwobolApplication {

    static void main(String[] args) {
        SpringApplication.run(MwobolApplication.class, args);
    }
}
