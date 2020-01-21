package com.coffesshop.integrations;

import feign.Request;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public Request.Options timeoutConfigurations(){
        return new Request.Options(30000,20000);
    }


}
