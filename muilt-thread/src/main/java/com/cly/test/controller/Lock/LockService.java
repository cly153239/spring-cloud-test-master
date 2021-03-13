package com.cly.test.controller.Lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@Slf4j
public class LockService implements Callable {
    Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void test(String name){
        lock.lock();
        try{
            for(int i=0;i<10;i++){
                log.info(name+"i===================>"+i);
                if(!StringUtils.isEmpty(name)&&name.contains("A")&&i==3){
                    //Thread.sleep(2000);
                    condition.await(5000, TimeUnit.MILLISECONDS);
                }
                if(!StringUtils.isEmpty(name)&&name.contains("B")){
                    //Thread.sleep(2000);
                    condition.signal();
                }
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

    @Override
    public Object call() throws Exception {
        log.info(">>>>>>>>>>>>>>>>>>klloo");
        return "jekkkk";
    }
}
