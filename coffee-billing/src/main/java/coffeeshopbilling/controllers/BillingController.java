package coffeeshopbilling.controllers;

import com.coffesshop.integrations.Bill;
import com.coffesshop.integrations.Billing;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController implements Billing {

    @Override
    public Bill billCoffee(String userName, String coffeeType, int size) {
        System.out.println("Preparing bill for user "+userName +" Thread  -c"+Thread.currentThread().getName());
        Bill bill = new Bill(userName,size*2,"$");
        try {
            Thread.sleep(1000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        return bill;

    }
}
