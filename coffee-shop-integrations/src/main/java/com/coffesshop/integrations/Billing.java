package com.coffesshop.integrations;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "billing-service",value = "api-gateway" )
@RibbonClient(value = "billing-services")
public interface Billing {

    @RequestMapping(value = "/billing-services/bill-coffee",produces ="application/json")
    Bill billCoffee(@RequestParam("userName") String userName,
                    @RequestParam("coffeeType") String coffeeType,
                    @RequestParam("size") int size);
}
