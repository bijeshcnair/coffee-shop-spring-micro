package com.coffeeshop.client.coffeeshopclient.controllers;


import com.coffeeshop.client.coffeeshopclient.models.MakeCoffeeResponse;
import com.coffesshop.integrations.Barista;
import com.coffesshop.integrations.Bill;
import com.coffesshop.integrations.Billing;
import com.coffesshop.integrations.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CoffeeShopController {

    @Autowired
    Barista barista;

    @Autowired
    Billing billing;


    @GetMapping(value = "/prepare-coffee",produces = "application/json")
    public ResponseEntity<MakeCoffeeResponse> makeCoffee(@RequestParam("userName") String userName,
                                                         @RequestParam("type") String type,
                                                         @RequestParam ("size") int size){

        System.out.println("Preparing coffee : "+type+" ... Sending request to barista ");
        if(barista.prepareCoffee(type,size)){
            System.out.println("Coffee prepared. Prepare bill now");
            Bill bill = billing.billCoffee(userName,type,size);
            return ResponseEntity.ok(prepareBillingAndMakeResponseForCoffee(bill));

        }else{
            return ResponseEntity.ok(makeCoffeeFailed(userName));
        }
    }

    @GetMapping(value = "/coffees")
    public List<Coffee> getAllCoffees(){

        return barista.getAllCoffees();
    }
    private MakeCoffeeResponse prepareBillingAndMakeResponseForCoffee(Bill bill){


        return new MakeCoffeeResponse(bill.getUserName(),
                true,
                bill.getAmount()+" "+bill.getCurrency());

    }

    @GetMapping(value = "/coffees/{id}",produces = "application/hal+json")
    Resource<Coffee> getCoffee(@PathVariable int id){
        return barista.getCoffee(id);
    }
    private MakeCoffeeResponse makeCoffeeFailed(String userName){

        return new MakeCoffeeResponse(userName,
                false,
                "0");


    }





}
