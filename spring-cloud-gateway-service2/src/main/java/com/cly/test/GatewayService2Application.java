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
public class GatewayService2Application {
    public static void main(String[] args){
        SpringApplication.run(GatewayService2Application.class, args);
    }
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(@RequestParam("name")String name){
      return String.format("gateway service2,name is %s",name);
    }

}
