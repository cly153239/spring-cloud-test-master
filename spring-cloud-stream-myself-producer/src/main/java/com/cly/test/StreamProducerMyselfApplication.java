package com.cly.test;


import com.cly.test.service.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableBinding(MyProcessor.class)
public class StreamProducerMyselfApplication {
    public static void main(String[] args){
        SpringApplication.run(StreamProducerMyselfApplication.class, args);
    }
    @Autowired
    private MyProcessor myProcessor;
    @RequestMapping(value = "/hello")
    @Output(MyProcessor.MESSAGE_OUTPUT)
    public void hello() {
        Message<String> message=MessageBuilder.withPayload("hello world output").build();
        myProcessor.output().send(message);
    }

}
