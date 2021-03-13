package com.cly.test.controller.TestThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestService1 {
    private String name=new String();
    synchronized public void Test1(){
        log.info(">>>>>>>>>>>>>>>>>>>TestService1开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(">>>>>>>>>>>>>>>>>>>TestService1结束");
    }

    synchronized public void Test2(){
       /* synchronized (this){
            log.info(">>>>>>>>>>>>>>>>>>>TestService2开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(">>>>>>>>>>>>>>>>>>>TestService2结束");
        }*/

        log.info(">>>>>>>>>>>>>>>>>>>TestService2开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(">>>>>>>>>>>>>>>>>>>TestService2结束");

    }
}
