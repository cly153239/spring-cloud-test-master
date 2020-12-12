package com.cly.test;

import com.cly.test.thread.ThreadTaskTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
@RestController
@Slf4j
public class SpringThreadApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringThreadApplication.class, args);
    }
    @RequestMapping(value = "/hello")
    @Async
    public void hello() throws InterruptedException {
        List<ThreadTaskTest> list=new LinkedList<>();
        for(int i=0;i<20;i++){
            list.add(new ThreadTaskTest());
        }
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        executorService.invokeAll(list);

    }


    @Resource(name="defaultThreadPool")
    private ThreadPoolTaskExecutor executor;
    @RequestMapping(value = "/hello1")
    @Async
    public void hello1(){
        for(int i=0;i<20;i++){
            int flag=i;
            Future<?> future=executor.submit(()->{
                log.info("=================================heloow eor kkjj"+flag);
            });
        }

    }

}
