package com.coffeeshop.apigateway;

import brave.sampler.Sampler;
import com.netflix.eureka.registry.rule.AlwaysMatchInstanceStatusRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * API gateway takes care
 * 1) Authentication, authorization and security
 * 2) Rate limits
 * 3) Fault Tolerance
 * 4) Service aggregation
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiGateway {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateway.class, args);
    }

    @Bean
    public Sampler sampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

}
