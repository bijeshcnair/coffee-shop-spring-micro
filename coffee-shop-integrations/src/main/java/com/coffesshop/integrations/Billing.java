package com.coffesshop.integrations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("billing-client-service")
public interface Billing {

    @RequestMapping("/bill-coffee")
    boolean billCoffee(String userName,String coffeeType, String size);
}
