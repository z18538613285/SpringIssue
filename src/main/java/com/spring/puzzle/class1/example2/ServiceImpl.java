package com.spring.puzzle.class1.example2;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl {

    private String serviceName;

    public ServiceImpl(String serviceName){
        this.serviceName = serviceName;
    }

    public ServiceImpl(String serviceName, String otherStringParameter){
        this.serviceName = serviceName;
    }

    /**
     *
     *存在两个
     * 构造器，都可以调用时，到底应该调用哪个呢？最终 Spring 无从选择，只能尝试去调用默
     * 认构造器，而这个默认构造器又不存在，所以测试这个程序它会出错
     */

/*    private List<String> serviceNames;
    public ServiceImpl(List<String> serviceNames){
        this.serviceNames = serviceNames;
        System.out.println(this.serviceNames);
    }*/
}