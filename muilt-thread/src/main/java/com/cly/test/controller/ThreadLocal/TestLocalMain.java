package com.cly.test.controller.ThreadLocal;

import com.cly.test.controller.TestLock.TestLock;
import com.cly.test.controller.TestLock.ThreadA;
import com.cly.test.controller.TestLock.ThreadB;

public class TestLocalMain {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
       ThreadLocalA threadLocalA=new ThreadLocalA();
       Thread threadA=new Thread(threadLocalA,"A");
       threadA.start();
       Thread threadB=new Thread(threadLocalA,"B");
       threadB.start();
    }
}
