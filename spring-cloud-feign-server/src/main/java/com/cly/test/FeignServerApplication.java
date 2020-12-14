package com.cly.test;

import com.cly.test.service.FeignClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class FeignServerApplication {
    public static void main(String[] args){
        SpringApplication.run(FeignServerApplication.class, args);
    }
    @Autowired
    private FeignClientInterface feignClientInterface;
    @RequestMapping(value = "/hello")
    public String hello() {
        return feignClientInterface.hello();
    }
}
