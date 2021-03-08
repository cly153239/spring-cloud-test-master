package com.cly.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class GatewayService1Application {
    public static void main(String[] args){
        SpringApplication.run(GatewayService1Application.class, args);
    }
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
     return String.format("gateway service1,name is %s","cly");
    }

}
