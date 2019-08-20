package com.coffesshop.integrations;

import feign.Request;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public Request.Options timeoutConfigurations(){
        return new Request.Options(5000,20000);
    }
}