package com.cly.test;

import com.cly.test.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class RibbonService1Application {
    public static void main(String[] args){
        SpringApplication.run(RibbonService1Application.class, args);
    }
    @Autowired
    private RedisUtil redisUtil;
    private static final String LOCK_KEY="lock_key";

    private static final String LOCK_VALUE="lock_value1";

    private static final String COUNT="count";
    @RequestMapping(value = "/hello")
    public String hello() {
        try {
            while (true){
                if(redisUtil.setIfAbsent(LOCK_KEY,LOCK_VALUE)){
                    redisUtil.expire(LOCK_KEY,1);
                    if(redisUtil.setIfAbsent(COUNT,100)){
                        return "hello 8086";
                    }
                    int num=(Integer)redisUtil.get(COUNT);
                    log.info("====================count=========="+num);
                    redisUtil.set(COUNT,num-1);
                    return "hello 8086";

                }
                log.info("==============堵住");
            }

        }finally {
          /*  if(LOCK_VALUE.equals(redisUtil.get(LOCK_KEY))){
                redisUtil.del(LOCK_KEY);
            }*/
        }
    }

}
