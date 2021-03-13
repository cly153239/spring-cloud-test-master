package com.cly.test.controller.TestLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadB extends Thread{
    TestLock testLock;
    public ThreadB(TestLock testLock){
        this.testLock=testLock;
    }
    @Override
    public void run() {
        //testLock.test3("TestB");
        synchronized (testLock){
            log.info("ThreadB>>>>>>>>>>>>>>>>>>>begin");
            testLock.notify();
            log.info("ThreadB>>>>>>>>>>>>>>>>>>>end");
        }

    }
}
