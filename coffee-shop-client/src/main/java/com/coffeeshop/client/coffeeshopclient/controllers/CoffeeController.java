package com.coffeeshop.client.coffeeshopclient.controllers;


import com.coffesshop.integrations.Barista;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {

    @Autowired
    Barista barista;

    @RequestMapping("/prepare-coffee")
    public boolean makeCoffee(){

        System.out.println("Preparing coffee... Sending request to barista");

        return barista.prepareCoffee();
    }



}
