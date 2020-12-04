package com.cly.test;

import com.cly.test.rabbitmq.prodcut.service.SendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class StreamProducerApplication {
    public static void main(String[] args){
        SpringApplication.run(StreamProducerApplication.class, args);
    }
    @Autowired
    private SendMsgService sendMsgService;
    @RequestMapping(value = "/hello")
    public void hello() {
        sendMsgService.sendMessage("hello");
    }

}
