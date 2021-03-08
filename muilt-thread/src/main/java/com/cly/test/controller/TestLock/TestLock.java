package com.cly.test.controller.TestLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestLock {
    private String username=new String();
    synchronized public void test1(String name) throws InterruptedException {
        log.info("name1>>>>>>>>>>>>>>>>>"+name);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("name12>>>>>>>>>>>>>>>>>"+name);
       // test2(name);
    }
    public void test2(String name){
        log.info("name21>>>>>>>>>>>>>>>>>"+name);
       /* try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       synchronized (this){
           log.info("name2>>>>>>>>>>>>>>>>>"+name);
       }

    }
    public void test3(String name){
        synchronized (username){
            this.username=name;
            log.info("username1>>>>>>>>>>>>>>>"+this.username);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("username2>>>>>>>>>>>>>>>"+this.username);
        }
    }
}
