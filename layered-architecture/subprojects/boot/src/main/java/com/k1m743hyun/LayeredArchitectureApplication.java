package com.k1m743hyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LayeredArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayeredArchitectureApplication.class, args);
    }
}