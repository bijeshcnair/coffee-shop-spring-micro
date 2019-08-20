package com.coffesshop.integrations;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "barista-services",configuration = FeignConfiguration.class)
public interface Barista {

    @RequestMapping("/prepare-coffee")
    boolean prepareCoffee();

}
