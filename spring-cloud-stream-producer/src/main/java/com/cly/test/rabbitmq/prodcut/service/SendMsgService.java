package com.cly.test.rabbitmq.prodcut.service;

import org.springframework.integration.core.MessageSource;

public interface SendMsgService {
    public void sendMessage(String content);
}
