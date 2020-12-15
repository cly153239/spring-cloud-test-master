package com.cly.test.service;

import org.springframework.stereotype.Component;

@Component
public class FeignClientInterError implements FeignClientInterface {
    @Override
    public String hello() {
        return "error hy";
    }
}
