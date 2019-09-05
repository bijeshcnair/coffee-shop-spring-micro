package com.coffesshop.integrations;

import org.springframework.stereotype.Component;

@Component
public class BillingFallBack implements Billing {

    @Override
    public Bill billCoffee(String userName, String coffeeType, int size) {
        Bill bill
                = new Bill("wrong",0,"$");
        return bill;
    }
}
