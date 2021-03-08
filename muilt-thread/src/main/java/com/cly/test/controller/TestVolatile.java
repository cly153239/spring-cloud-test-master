package com.cly.test.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestVolatile {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        log.info("processors>>>>>>>>>>>>>"+Runtime.getRuntime().availableProcessors());
        while (true){
           /*synchronized (threadDemo){
               if (threadDemo.isFlag()){
                   System.out.println("主线程读取到的flag = " + threadDemo.isFlag());
                   break;
               }
           }*/
            if (threadDemo.isFlag()){
                System.out.println("主线程读取到的flag = " + threadDemo.isFlag());
                break;
            }
        }
    }
}
