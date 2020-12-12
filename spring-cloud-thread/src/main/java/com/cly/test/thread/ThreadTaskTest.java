package com.cly.test.thread;

import lombok.extern.slf4j.Slf4j;

import javax.security.auth.callback.Callback;
import java.util.concurrent.Callable;
@Slf4j
public class ThreadTaskTest implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
    log.info("++++++++++++++++++++++++++hello world");
        return true;
    }
}
