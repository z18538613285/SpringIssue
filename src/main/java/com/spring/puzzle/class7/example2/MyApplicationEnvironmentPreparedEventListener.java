package com.spring.puzzle.class7.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/***
 *
 * ：我们定义的监听器并不能监听到 initialMulticaster
 * 广播出的 ApplicationEnvironmentPreparedEvent。
 */

@Slf4j
@Component
public class MyApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent > {

    public MyApplicationEnvironmentPreparedEventListener(){

    }
    @Override
    public void onApplicationEvent(final ApplicationEnvironmentPreparedEvent event) {
        log.info("{} received: {}", this.toString(), event);
    }

}