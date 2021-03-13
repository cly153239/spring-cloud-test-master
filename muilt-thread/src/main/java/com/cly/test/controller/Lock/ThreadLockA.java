package com.cly.test.controller.Lock;

public class ThreadLockA extends Thread {
    private LockService lockService;
    public ThreadLockA(LockService lockService){
        this.lockService=lockService;
    }
    @Override
    public void run() {
      lockService.test("ThreadLockA");
    }
}
