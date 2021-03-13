package com.cly.test.controller.TestThread;

public class Thread1 extends Thread {
    TestService1 testService1;
    public Thread1(TestService1 testService1){
        this.testService1=testService1;
    }
    @Override
    public void run() {
        //testLock.test3("TestB");
       testService1.Test1();

    }
}
