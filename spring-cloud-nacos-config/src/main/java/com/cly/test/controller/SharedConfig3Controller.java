package com.cly.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class SharedConfig3Controller {
    @Value("${share.config3}")
    private String shareConfig3;
    @RequestMapping(value="/getShareConfig3",method = RequestMethod.GET)
    public String getConfig3(){
        return shareConfig3;
    }

    @Value("${share.config4}")
    private String shareConfig4;
    @RequestMapping(value="/getShareConfig4",method = RequestMethod.GET)
    public String getConfig4(){
        return shareConfig4;
    }
}
