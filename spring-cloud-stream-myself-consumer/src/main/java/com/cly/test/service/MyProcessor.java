package com.cly.test.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MyProcessor {
    String MESSAGE_INPUT="input";
    String MESSAGE_LOG_INPUT="logInput";
    String MESSAGE_LOG_OUTPUT="logOutput";
    @Input(MESSAGE_INPUT)
    SubscribableChannel input();
    @Output(MESSAGE_LOG_OUTPUT)
    MessageChannel logOutput();
    @Input(MESSAGE_LOG_INPUT)
    SubscribableChannel logInput();
}
