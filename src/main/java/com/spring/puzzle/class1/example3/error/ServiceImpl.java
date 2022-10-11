package com.spring.puzzle.class1.example3.error;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 *
 * 当一个单例的 Bean，使用 autowired 注解标记其属性时，你一定要注意这个属性
 * 值会被固定下来。
 */

@Service
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ServiceImpl {
}