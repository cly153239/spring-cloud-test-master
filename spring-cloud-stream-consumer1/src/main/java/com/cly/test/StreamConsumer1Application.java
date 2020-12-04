package com.cly.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class StreamConsumer1Application {
    public static void main(String[] args){
        SpringApplication.run(StreamConsumer1Application.class, args);
    }

}
