package com.coffee.barista.controllers;


import com.coffesshop.integrations.Barista;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController implements Barista {

    @Override
    public boolean prepareCoffee(String type,int size) {

        try {
            Thread.sleep(3000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Coffee prepared by barista . Type : "+type +" and Size : "+size);
        return true;
    }
}
