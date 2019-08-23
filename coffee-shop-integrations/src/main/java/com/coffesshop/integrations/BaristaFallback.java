package com.coffesshop.integrations;

import org.springframework.stereotype.Component;

@Component
public class BaristaFallback implements Barista {

    @Override
    public boolean prepareCoffee(String type, int size) {
        System.out.println("Failed to prepare the coffee ");
        return false;
    }



}
