package com.spring.puzzle.class5.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricService {

    /**
     *只有引用的是被动态代理创建出来的对象，才会被 Spring
     * 增强，具备 AOP 该有的功能。
     */

    @Autowired
    ElectricService electricService;

    public void charge() throws Exception {
        System.out.println("Electric charging ...");
//        this.pay();

         electricService.pay();

/*        ElectricService electric = ((ElectricService) AopContext.currentProxy());
        electric.pay();*/

    }

    public void pay() throws Exception {
        System.out.println("Pay with alipay ...");
        Thread.sleep(1000);
    }

}