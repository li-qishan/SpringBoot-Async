package com.jhons.async.springbootasync.handler;


import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AsyncHandler {

    @Async
    public Long handler(long batch) {
        log.info("任务任务开始执行....批次号：" + batch);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("任务任务执行结束....批次号：" + batch + "，完成时间：" + LocalDateTime.now());
        return batch;
    }
}
