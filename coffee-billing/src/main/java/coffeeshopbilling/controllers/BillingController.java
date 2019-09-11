package coffeeshopbilling.controllers;

import com.coffesshop.integrations.Bill;
import com.coffesshop.integrations.Billing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {
Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/bill-coffee",produces ="application/json")

    public Bill billCoffee(@RequestParam("userName") String userName,
                           @RequestParam("coffeeType") String coffeeType,
                           @RequestParam("size") int size) {
        logger.info("Preparing bill for user "+userName +" Thread  -c"+Thread.currentThread().getName());
        Bill bill = new Bill(userName,size*2,"$");
        try {
            Thread.sleep(1);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        return bill;

    }
}
