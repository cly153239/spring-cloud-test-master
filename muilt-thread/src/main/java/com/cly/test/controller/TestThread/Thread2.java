package com.cly.test.controller.TestThread;

public class Thread2 extends Thread {
    TestService1 testService1;
    public Thread2(TestService1 testService1){
        this.testService1=testService1;
    }
    @Override
    public void run() {
        //testLock.test3("TestB");
       testService1.Test2();

    }
}
