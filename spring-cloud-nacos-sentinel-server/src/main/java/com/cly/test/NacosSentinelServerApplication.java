package com.cly.test;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosSentinelServerApplication {
    public static void main(String[] args){
        SpringApplication.run(NacosSentinelServerApplication.class, args);
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    //@SentinelResource(value = "test.hello",fallback = "helloError")
    public String hello() {
       return "nacos balance";
    }

    public String helloError(String name, Throwable e){
        return "error,"+name;
    }
}
