package com.spring.puzzle.class7;

import com.spring.puzzle.class7.example3.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.context.support.AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME;

/***
 *
 * 最终事件的执行是由同一
 * 个线程按顺序来完成的，任何一个报错，都会导致后续的监听器执行不了。
 */

@RestController
@Slf4j
public class HelloWorldController {


    @Autowired
    private AbstractApplicationContext applicationContext;
    ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

    @RequestMapping(path = "publishEvent", method = RequestMethod.GET)
    public String notifyEvent(){
//        applicationContext.start();
//        applicationContext.stop();
//        applicationContext.close();
        log.info("start to publish event");
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = applicationContext.getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, SimpleApplicationEventMulticaster.class);
        /***
         *事件的发布和执行使用的都是 nio-8080-exec-1 线程，但是在事件比
         * 较多时，我们往往希望事件执行得更快些，或者希望事件的执行可以异步化不影响主线
         * 程。此时应该怎么做呢？
         */

        simpleApplicationEventMulticaster.setTaskExecutor(newCachedThreadPool);
//
        simpleApplicationEventMulticaster.setErrorHandler(TaskUtils.LOG_AND_SUPPRESS_ERROR_HANDLER);
//
        applicationContext.publishEvent(new MyEvent(UUID.randomUUID()));
        return "ok";
    };
}
