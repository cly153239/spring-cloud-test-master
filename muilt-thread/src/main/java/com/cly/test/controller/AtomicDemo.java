package com.cly.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicDemo implements Runnable {
    private AtomicInteger i=new AtomicInteger();
    public int getI(){
        return i.getAndIncrement();
    }
    @Override
    public void run() {
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        ExecutorService executorService=new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(10));

    }
}
