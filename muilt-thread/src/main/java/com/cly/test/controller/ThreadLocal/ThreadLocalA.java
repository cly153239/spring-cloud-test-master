package com.cly.test.controller.ThreadLocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalA implements Runnable {
    private ThreadLocal threadLocal=new ThreadLocal();
    private int num=0;
    @Override
    public void run() {
        int value=(int) (Math.random() * 100D);
        num=value;
        threadLocal.set(value);
        log.info(num+">>>>>>>>>>>>>>>>开始"+value);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(num+">>>>>>>>>>>>>>>>结束"+(int)threadLocal.get());
    }
}
