package com.cly.test.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="ribbon-service",fallback = FeignClientInterError.class)
public interface FeignClientInterface {
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello();
}
