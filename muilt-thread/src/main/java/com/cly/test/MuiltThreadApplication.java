package com.cly.test;

import com.cly.test.service.MuiltThreadTestService;
import com.cly.test.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;


@SpringBootApplication
@Slf4j
@RestController
@EnableAsync
public class MuiltThreadApplication {
    @Autowired
    private RedisUtil redisUtil;
    public static void main(String[] args){
        SpringApplication.run(MuiltThreadApplication.class, args);

    }
    @Autowired
    MuiltThreadTestService muiltThreadTestService;
   @RequestMapping(value = "test",method = RequestMethod.GET)
    public void test(){
       log.info("start===============12");
       log.error("errot=========================err");
        muiltThreadTestService.threadTest();
       log.info("end===============12123");
       log.error("errot1233=========================err");
    }

    @RequestMapping(value = "setCount",method = RequestMethod.GET)
    public void  setCount(@RequestParam(value="count")Integer count){
        redisUtil.set("muilt-thred-count",count);
    }

}
