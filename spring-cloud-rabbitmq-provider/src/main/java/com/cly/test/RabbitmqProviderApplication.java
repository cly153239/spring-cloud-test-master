package com.cly.test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RabbitmqProviderApplication {
    public static void main(String[] args){
        SpringApplication.run(RabbitmqProviderApplication.class, args);
    }
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping(value="/sendMessage",method = RequestMethod.GET)
    public String sendMessage(){
        Map<String,String> map=new HashMap<>();
        map.put("hello","hello");
        map.put("world","world");
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",map);
        return "ok";
    }
}
