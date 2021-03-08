package com.cly.test.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ThreadDemo implements Runnable {
    private volatile boolean flag=false;
    @Override
    public void run() {
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        flag=true;
        log.info("ThreadDemo>>>>>>>>>>>>>>>>>>>>"+flag);
    }
}
