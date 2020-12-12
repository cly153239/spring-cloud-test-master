package com.cly.test.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class TaskTest {
    //输出时间格式
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:sss");
    @Scheduled(cron = "*/15 * * * * ?")
    private void sayHello(){
        String dateTime = format.format(new Date());
        log.info("{} 向宇宙发出了一声问候: Hello World!", dateTime);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "*/16 * * * * ?")
    private void sayHello2(){
        String dateTime = format.format(new Date());
        log.info("{} 向宇宙发出了一声问候: 你好,世界", dateTime);
    }
}
