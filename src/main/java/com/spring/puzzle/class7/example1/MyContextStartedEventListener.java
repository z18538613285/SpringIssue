package com.spring.puzzle.class7.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/***
 *
 * ：当一
 * 个事件拦截不了时，我们第一个要查的是拦截的事件类型对不对，执行的代码能不能抛出
 * 它。把握好这点，也就事半功倍了。
 */

@Slf4j
@Component
public class MyContextStartedEventListener implements ApplicationListener<ContextStartedEvent> {

  @Override
  public void onApplicationEvent(final ContextStartedEvent event) {
    log.info("{} received: {}", this.toString(), event);
  }

}