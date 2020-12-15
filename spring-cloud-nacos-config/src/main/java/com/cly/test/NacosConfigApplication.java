package com.cly.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class NacosConfigApplication {
    public static void main(String[] args){
        SpringApplication.run(NacosConfigApplication.class, args);
    }

    @Value("${nacos.config}")
    private String configValue;
    @RequestMapping(value = "/hello")
    public String hello() {
        log.info("==============================config==========="+configValue);
       return configValue;
    }
}
