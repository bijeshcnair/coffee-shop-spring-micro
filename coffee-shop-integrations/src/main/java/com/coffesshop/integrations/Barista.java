package com.coffesshop.integrations;


import com.coffesshop.integrations.model.Coffee;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "barista-services"
        ,configuration = FeignConfiguration.class

       )
@RibbonClient(value = "braista-services",configuration = RibbonConfigurations.class)
public interface Barista {

    @RequestMapping("/prepare-coffee")
    boolean prepareCoffee(@RequestParam("type") String type,@RequestParam("size") int size);

    @GetMapping("/coffees")
    List<Coffee> getAllCoffees();

    @GetMapping(value = "/coffees/{id}",produces = "application/hal+json")
    Resource<Coffee> getCoffee(@PathVariable int id);

}
