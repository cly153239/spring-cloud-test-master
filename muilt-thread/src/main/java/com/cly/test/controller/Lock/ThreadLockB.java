package com.cly.test.controller.Lock;

public class ThreadLockB extends Thread {
    private LockService lockService;
    public ThreadLockB(LockService lockService){
        this.lockService=lockService;
    }
    @Override
    public void run() {
      lockService.test("ThreadLockB");
    }
}
