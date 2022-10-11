package com.spring.puzzle.class4.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public LightService getTransmission(){
        return new LightService();
    }

    /**
     *
     * 避免在 Java 类中定义一些带有特殊意义动词的方法来解决，当然如果一定要
     * 定义名为 close 或者 shutdown 方法，也可以通过将 Bean 注解内 destroyMethod 属性
     * 设置为空的方式来解决这个问题。
     */

   //修改方案之一：
  /*  @Bean(destroyMethod="")
    public LightService getTransmission(){
        return new LightService();
    }*/
}