package com.coffeeshop.client.coffeeshopclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.coffesshop.integrations")
@ComponentScan({"com.coffesshop.integrations","com.coffeeshop.client.coffeeshopclient"})
@EnableDiscoveryClient
public class CoffeeShopClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopClientApplication.class, args);
    }

}
