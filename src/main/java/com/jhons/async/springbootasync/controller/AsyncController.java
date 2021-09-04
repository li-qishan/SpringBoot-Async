package com.jhons.async.springbootasync.controller;

import com.jhons.async.springbootasync.handler.AsyncHandler;
import java.time.LocalDateTime;
import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AsyncController {
    @Resource
    private AsyncHandler asyncHandler;

    @RequestMapping("/async")
    public Object async() {
        long batch = System.currentTimeMillis();
        log.info("任务任务开始执行....批次号：" + batch+ "，交易时间：" + LocalDateTime.now());
        return batch + " : " + asyncHandler.handler(batch) + "，交易时间：" + LocalDateTime.now();
    }
}
