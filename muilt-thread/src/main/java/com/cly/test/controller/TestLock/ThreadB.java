package com.cly.test.controller.TestLock;

public class ThreadB extends Thread{
    TestLock testLock;
    public ThreadB(TestLock testLock){
        this.testLock=testLock;
    }
    @Override
    public void run() {
        testLock.test3("TestB");
    }
}
