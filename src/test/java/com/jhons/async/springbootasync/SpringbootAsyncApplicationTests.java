package com.jhons.async.springbootasync;

import com.jhons.async.springbootasync.task.Task;
import com.jhons.async.springbootasync.task.TaskAsync;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@SpringBootTest
class SpringbootAsyncApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource(name = "task")
    private Task task;

    @Resource(name = "taskAsync")
    private TaskAsync taskAsync;

    @Test
    public void test() throws Exception {
        //任务全部完成，总耗时：21335毫秒
        long start = System.currentTimeMillis();

        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void testAsync() throws Exception {
        //任务全部完成，总耗时：10007毫秒
        long start = System.currentTimeMillis();

        Future<String> stringFuture1 = taskAsync.doTaskOne();
        Future<String> stringFuture2 = taskAsync.doTaskTwo();
        Future<String> stringFuture3 = taskAsync.doTaskThree();
        while(true) {
            if(stringFuture1.isDone() && stringFuture2.isDone() && stringFuture3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }

}
