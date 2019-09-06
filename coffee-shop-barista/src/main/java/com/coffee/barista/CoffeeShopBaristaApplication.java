package com.coffee.barista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CoffeeShopBaristaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopBaristaApplication.class, args);
    }

}
