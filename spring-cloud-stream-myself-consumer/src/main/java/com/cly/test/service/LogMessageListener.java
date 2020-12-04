package com.cly.test.service;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Publisher;
import org.springframework.integration.aop.PublisherAnnotationBeanPostProcessor;
import org.springframework.integration.context.IntegrationContextUtils;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MyProcessor.class)
public class LogMessageListener {
    @StreamListener(MyProcessor.MESSAGE_INPUT)
    @SendTo(MyProcessor.MESSAGE_LOG_OUTPUT)
    public String processLogMessage(String message) {
        System.out.println(message);
        return "「" + message +"」";
    }

    @StreamListener(MyProcessor.MESSAGE_LOG_INPUT)
    public void processMessage(String message){
        System.out.println("message====================="+message);
    }


}
