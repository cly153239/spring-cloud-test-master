package com.cly.test.controller.Lock;

import com.cly.test.controller.AtomicDemo;
import com.cly.test.controller.TestLock.TestLock;
import com.cly.test.controller.TestLock.ThreadA;
import com.cly.test.controller.TestLock.ThreadB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class LockMain {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
     /*  LockService lockService=new LockService();
       ThreadLockA threadLockA=new ThreadLockA(lockService);
       threadLockA.start();
       ThreadLockB threadLockB=new ThreadLockB(lockService);
       threadLockB.start();
       ThreadLockB threadLockB1=new ThreadLockB(lockService);
      // threadLockB1.start();*/

       /* AtomicInteger atomicInteger=new AtomicInteger(3);
        int i=atomicInteger.getAndIncrement();
        log.info(">>>>>>>>>>>>"+i);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>"+atomicInteger.get());
        AtomicBoolean atomicBoolean=new AtomicBoolean(true);*/
/*
        AtomicReference<String> atomicReference=new AtomicReference<>();
        String str="hello wolrd";
        atomicReference.set(str);
        log.info(">>>>>>>>>>>>>1>>>>>>"+atomicReference.get());
        log.info(">>>>>>>>>>>>>>>>>>2>>>>>>>>>>"+atomicReference.compareAndSet(str,"hi tom"));
        log.info(">>>>>>>>>>>>>>3>>>>>>>>>>>>>>"+atomicReference.get());
*/
/*ExecutorService executorService=Executors.newSingleThreadExecutor();

        FutureTask futureTask=new FutureTask(new LockService());
        executorService.submit(futureTask);
        try {
            String str1=(String)futureTask.get();
            log.info(">>>>>>>>>>>>>>>>>>>>str1="+str1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/


        /*Thread thread=new Thread(futureTask);
        thread.start();*/


        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(6,10,60,TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));
           for(int i=0;i<20;i++){
               FutureTask futureTask=new FutureTask(new LockService());
               threadPoolExecutor.execute(futureTask);

               try {
                   String str1=(String)futureTask.get();
                   log.info(">>>>>>>>>>>>>>>>>>>>str1="+str1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (ExecutionException e) {
                   e.printStackTrace();
               }
           }
    }
}
