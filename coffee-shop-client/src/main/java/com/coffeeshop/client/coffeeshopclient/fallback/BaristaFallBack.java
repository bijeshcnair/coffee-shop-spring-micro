package com.coffeeshop.client.coffeeshopclient.fallback;

import com.coffesshop.integrations.Barista;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class BaristaFallBack implements Barista {
    @Override
    public boolean prepareCoffee(String type, int size) {
        System.out.println("Failed to prepare coffee");
        return false;

    }
}
