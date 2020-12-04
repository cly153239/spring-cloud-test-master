package com.cly.test.rabbitmq.prodcut.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;


@EnableBinding(Source.class)
public class SendMsgServiceImpl implements SendMsgService{
    @Autowired
    private Source source;
    @Override
    public void  sendMessage(String content) {
        source.output().send(MessageBuilder.withPayload(content).build());
    }
}
