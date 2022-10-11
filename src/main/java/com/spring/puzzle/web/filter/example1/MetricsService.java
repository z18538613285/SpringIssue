package com.spring.puzzle.web.filter.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

/*
    @Autowired
    public TimeCostFilter timeCostFilter;
*/

    //下面为修改方法
    /**
     *
     * 注入的类型是 FilterRegistrationBean 类型，而不是 TimeCostFilter 类型；
     * 注入的名称是包含包名的长名称，即 com.spring.puzzle.filter.TimeCostFilter（不能用
     * TimeCostFilter），以便于存在多个过滤器时进行精确匹配。
     */

    @Autowired
    @Qualifier("com.spring.puzzle.web.filter.example1.TimeCostFilter")
    FilterRegistrationBean timeCostFilter;

}
