package com.cly.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class RabbitmqComsumerApplication {
    public static void main(String[] args){
        SpringApplication.run(RabbitmqComsumerApplication.class, args);
    }

}
