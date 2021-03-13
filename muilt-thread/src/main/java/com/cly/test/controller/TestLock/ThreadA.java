package com.cly.test.controller.TestLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadA extends Thread{
    TestLock testLock;
    public ThreadA(TestLock testLock){
        this.testLock=testLock;
    }
    @Override
    public void run() {
       /* try {
            testLock.test1("TestA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       synchronized (testLock){
           log.info("ThreadA>>>>>>>>>>>>>>>>>>>begin");
           try {
               testLock.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           log.info("ThreadA>>>>>>>>>>>>>>>>>>>end");
       }
    }
}
