package com.cly.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbonTest")
public class RibbonTestController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "handleFail")
    public Object hello(){
        return restTemplate.getForObject("http://RIBBON-SERVICE/hello",String.class);
    }

    private String handleFail(){
        return "fail request";
    }
}
