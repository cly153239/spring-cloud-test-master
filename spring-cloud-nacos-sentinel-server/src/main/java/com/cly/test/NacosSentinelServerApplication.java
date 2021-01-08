package com.cly.test;


import com.alibaba.cloud.sentinel.datasource.RuleType;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;


@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosSentinelServerApplication {
    public static void main(String[] args){
        SpringApplication.run(NacosSentinelServerApplication.class, args);
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @SentinelResource(value = "testHello",fallback = "helloError",blockHandler = "blockMethod")
    public String hello() {
       return "nacos balance";
    }

    public String helloError(String name, Throwable e){
        return "error,"+name;
    }
    @RequestMapping(value ="getById/{id}",method = RequestMethod.GET)
    //@SentinelResource(value="getRecord",blockHandler = "blockMethod")
    public String getRecord(@PathVariable String id){
        return id;
    }

    @RequestMapping(value ="/getById",method = RequestMethod.GET)
    @SentinelResource(value="getRecord",fallback = "helloError",blockHandler = "blockMethod")
    public String getRecord1(@RequestParam(value = "id",required = false)String id){
        return id+"==================";
    }
    public String blockMethod(String id, BlockException e){
        return "热点"+id+"error";
    }

}
