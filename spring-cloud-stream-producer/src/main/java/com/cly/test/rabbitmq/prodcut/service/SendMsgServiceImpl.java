package com.cly.test.rabbitmq.prodcut.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;


@EnableBinding(Source.class)
public class SendMsgServiceImpl implements SendMsgService{
    @Autowired
    private Source source;
    @Override
    public void  sendMessage(String content) {
        List<String> list=new ArrayList<>();
        list.add(content);
        source.output().send(MessageBuilder.withPayload(list).build());
    }
}
