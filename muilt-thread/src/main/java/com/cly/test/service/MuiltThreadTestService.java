package com.cly.test.service;

import com.cly.test.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class MuiltThreadTestService {
    @Autowired
    private RedisUtil redisUtil;
    Lock lock=new ReentrantLock();
    @Async
    public void threadTest(){
       try{
           lock.lock();
           Integer count=(Integer)redisUtil.get("muilt-thred-count");
           log.info("======================================第"+count);
           redisUtil.set("muilt-thred-count",count==null?100:count-1);
       }catch (Exception e){

       }finally {
            lock.unlock();
       }


    }
}
