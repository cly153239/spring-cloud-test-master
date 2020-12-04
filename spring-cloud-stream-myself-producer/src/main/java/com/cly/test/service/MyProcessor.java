package com.cly.test.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MyProcessor {
    String MESSAGE_OUTPUT="output";
    @Output(MESSAGE_OUTPUT)
    MessageChannel output();

}
