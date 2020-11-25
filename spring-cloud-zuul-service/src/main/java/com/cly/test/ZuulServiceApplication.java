package com.cly.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
public class ZuulServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(ZuulServiceApplication.class, args);
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello 8091";
    }
}
