package com.spring.puzzle.web.filter.example2;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class DemoFilter implements Filter {
    /**
     *
     * 职责链则是一
     * 个对象把子任务交给其他对象的同名方法去完成
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            //模拟异常
            System.out.println("Filter处理中时发生异常");
            throw new RuntimeException();
        } catch (Exception e) {
            // 不管怎么调用，不能多次调用
            //FilterChain#doFilter()
            //chain.doFilter(request, response);
        }
        chain.doFilter(request, response);
    }

}

