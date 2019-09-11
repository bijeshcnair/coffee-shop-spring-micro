package com.coffesshop.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

public class ZipkinServer {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServer.class, args);
    }

}
