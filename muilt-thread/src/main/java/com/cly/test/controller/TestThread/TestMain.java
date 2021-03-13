package com.cly.test.controller.TestThread;

import com.cly.test.controller.TestLock.TestLock;
import com.cly.test.controller.TestLock.ThreadA;
import com.cly.test.controller.TestLock.ThreadB;

import java.util.concurrent.ConcurrentHashMap;

public class TestMain {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
      /* TestService1 testService1=new TestService1();
       Thread1 thread1=new Thread1(testService1);
       Thread2 thread2=new Thread2(testService1);
       thread1.start();
       thread2.start();*/

        TestService2 testService1=new TestService2();
        Thread3 thread1=new Thread3(testService1);
        Thread4 thread2=new Thread4(testService1);
        thread1.start();
        thread2.start();

    }
}
