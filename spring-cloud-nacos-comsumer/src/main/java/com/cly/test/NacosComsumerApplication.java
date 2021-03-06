package com.cly.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class NacosComsumerApplication {
    public static void main(String[] args){
        SpringApplication.run(NacosComsumerApplication.class, args);
    }
    @Autowired
    private RestTemplate restTemplate;
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @RequestMapping(value = "/hello")
    public void hello() {
        String result=restTemplate.getForObject("http://nacos-server/hello",String.class);
        log.info("=================================result=================="+result);
    }
}
