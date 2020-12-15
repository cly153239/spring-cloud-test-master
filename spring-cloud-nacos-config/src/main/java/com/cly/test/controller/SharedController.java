package com.cly.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class SharedController {
   @Value("${share.config1}")
    private String shareConfig1;
    @RequestMapping(method = RequestMethod.GET,value = "/getShareConfig1")
    public String getShareConfig1(){
        return shareConfig1;
    }

    //@Value("${share.config2}")
    private String shareConfig2;
    @RequestMapping(method = RequestMethod.GET,value = "/getShareConfig2")
    public String getShareConfig2(){
        return shareConfig2;
    }
}
