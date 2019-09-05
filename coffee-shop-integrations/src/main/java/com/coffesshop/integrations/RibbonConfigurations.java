package com.coffesshop.integrations;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RibbonConfigurations {

    @Bean
    public  IRule iRule(){
         return new BestAvailableRule();
    }

}
