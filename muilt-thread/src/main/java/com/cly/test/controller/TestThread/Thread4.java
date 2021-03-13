package com.cly.test.controller.TestThread;

public class Thread4 extends Thread {
    TestService2 testService1;
    public Thread4(TestService2 testService1){
        this.testService1=testService1;
    }
    @Override
    public void run() {
        //testLock.test3("TestB");
       testService1.TestRead();

    }
}
