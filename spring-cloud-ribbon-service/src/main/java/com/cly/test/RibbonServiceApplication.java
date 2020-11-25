package com.cly.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RibbonServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(RibbonServiceApplication.class, args);
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello 8087";
    }
}
