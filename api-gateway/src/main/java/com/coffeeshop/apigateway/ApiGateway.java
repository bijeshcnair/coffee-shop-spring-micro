package com.coffeeshop.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

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

}
