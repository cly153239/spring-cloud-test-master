package com.cly.test.controller.TestLock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLockMain {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
        TestLock testLock=new TestLock();
        ThreadA threadA=new ThreadA(testLock);

        ThreadB threadB=new ThreadB(testLock);
        threadB.start();
        threadA.start();

    }
}
