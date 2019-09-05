package com.coffeeshop.client.coffeeshopclient.controllers;

import com.coffeeshop.client.coffeeshopclient.configurations.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/configuration")
public class ConfigurationController {

    @Autowired
    ConfigurationProperties configurationProperties;

    @GetMapping("/")
    public ConfigurationProperties configurationProperties(){

        return configurationProperties;
    }
}
