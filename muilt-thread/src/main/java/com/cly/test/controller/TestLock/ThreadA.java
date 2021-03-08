package com.cly.test.controller.TestLock;

public class ThreadA extends Thread{
    TestLock testLock;
    public ThreadA(TestLock testLock){
        this.testLock=testLock;
    }
    @Override
    public void run() {
        try {
            testLock.test1("TestA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
