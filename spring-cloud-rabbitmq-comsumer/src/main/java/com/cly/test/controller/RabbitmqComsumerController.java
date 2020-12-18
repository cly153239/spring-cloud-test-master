package com.cly.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RabbitListener(queues = "TestDirectQueue1")
@Slf4j
public class RabbitmqComsumerController {
    @RequestMapping(value="/getMessage",method = RequestMethod.GET)
    @RabbitHandler
    public void getMessage(Map<String,String> message){
       log.info("=======================================message==============="+message.toString());
    }
}
