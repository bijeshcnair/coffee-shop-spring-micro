package com.coffesshop.integrations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "billing-services",configuration = FeignConfiguration.class)
public interface Billing {

    @RequestMapping(value = "/bill-coffee",produces ="application/json")
    Bill billCoffee(@RequestParam("userName") String userName, @RequestParam("coffeeType") String coffeeType,@RequestParam("size") int size);
}
