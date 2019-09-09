package com.coffeeshop.client.coffeeshopclient.controllers;


import com.coffeeshop.client.coffeeshopclient.models.MakeCoffeeResponse;
import com.coffesshop.integrations.Barista;
import com.coffesshop.integrations.Bill;
import com.coffesshop.integrations.Billing;
import com.coffesshop.integrations.model.Coffee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CoffeeShopController {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Barista barista;

    @Autowired
    Billing billing;

    @GetMapping(value = "/prepare-coffee",produces = "application/json")
    public ResponseEntity<MakeCoffeeResponse> makeCoffee(@RequestParam("userName") String userName,
                                                         @RequestParam("type") String type,
                                                         @RequestParam ("size") int size){

        if(barista.prepareCoffee(type,size)){
            System.out.println("Coffee prepared. Prepare bill now");
            Bill bill = billing.billCoffee(userName,type,size);
            return ResponseEntity.ok(prepareBillingAndMakeResponseForCoffee(bill));

        }else{
            return ResponseEntity.ok(makeCoffeeFailed(userName));
        }
    }

    @GetMapping(value = "/coffees",produces = "application/json")
    public List<Coffee> getAllCoffees(){
        logger.info("Getting all coffee, coffee shop client");
        return barista.getAllCoffees();
    }
    private MakeCoffeeResponse prepareBillingAndMakeResponseForCoffee(Bill bill){


        return new MakeCoffeeResponse(bill.getUserName(),
                true,
                bill.getAmount()+" "+bill.getCurrency());

    }

    @GetMapping(value = "/coffees/{id}",produces = "application/hal+json")
    Resource<Coffee> getCoffee(@PathVariable int id)
    {
        logger.info("Reading a specific coffee {}",id);
        return barista.getCoffee(id);
    }
    private MakeCoffeeResponse makeCoffeeFailed(String userName){

        return new MakeCoffeeResponse(userName,
                false,
                "0");


    }





}
