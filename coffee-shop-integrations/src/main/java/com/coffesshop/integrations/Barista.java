package com.coffesshop.integrations;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "barista-services"
        ,configuration = FeignConfiguration.class
        ,fallback = BaristaFallback.class)
public interface Barista {

    @RequestMapping("/prepare-coffee")
   public boolean prepareCoffee(@RequestParam("type") String type,@RequestParam("size") int size);

  /*  @Component
    public class BaristaFallBackd implements Barista {
        @Override
        public boolean prepareCoffee(String type, int size) {
            System.out.println("Faileddd to prepare coffee");
            return false;

        }
    }*/
}
