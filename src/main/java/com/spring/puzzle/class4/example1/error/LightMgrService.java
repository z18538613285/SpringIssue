package com.spring.puzzle.class4.example1.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LightMgrService {

    @Autowired
    private LightService lightService;

    /**
     *于使用 @Autowired 直接标记在成
     * 员属性上而引发的装配行为是发生在构造器执行之后的。
     *
     * 所以构成 npm
     */

    public LightMgrService() {
        lightService.check();
    }
}