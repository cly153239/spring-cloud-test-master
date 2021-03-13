package com.cly.test.controller.TestThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class TestService2 {
    private ReentrantReadWriteLock rw=new ReentrantReadWriteLock();
    private Lock rLock=rw.readLock();
    private Lock wLock=rw.writeLock();
    private Condition condition=rLock.newCondition();
    public void TestWrite(){
        log.info(">>>>>>>>>>>>>>>>>>>>写开始");
        try{
            wLock.lock();
            condition.signal();
            log.info(">>>>>>>>>>>>>>>>>>>>柱塞开始");
            //LockSupport.park();
            log.info(">>>>>>>>>>>>>>>>>>>>写中");
            Thread.sleep(2000);
            log.info(">>>>>>>>>>>>>>>>>>>>写结束");
        }catch (Exception e){

        }finally {
            wLock.unlock();
        }


    }
    public void TestRead(){
        log.info(">>>>>>>>>>>>>>>>>>>>读开始");
        try{
            rLock.lock();
            log.info(">>>>>>>>>>>>>>>>>>>>读中");
            condition.await();
            //Thread.sleep(2000);
            log.info(">>>>>>>>>>>>>>>>>>>>读结束");
        }catch (Exception e){

        }finally {
            rLock.unlock();
        }


    }
}
