package com.spring.puzzle.web.filter.example4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * 当过滤器同时被 @WebFilter 和 @Component 修饰时，会导致两个
 * FilterRegistrationBean 实例的产生。addServletContextInitializerBeans() 和
 * addAdaptableBeans() 最终都会创建 FilterRegistrationBean 的实例
 */

@WebFilter
@Slf4j
@Order(1)
@Component
public class TimeCostFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("#开始计算接口耗时");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("#执行时间(ms)：" + time);
    }
}