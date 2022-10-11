package com.spring.puzzle.class3.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
@Slf4j
public class ValueTestController {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("#{student}")
    private Student student;

    /**
     * 所以命名时，我们一定要注意不仅要避免和环境变量冲
     * 突，也要注意避免和系统变量等其他变量冲突，
     * 胡志超,, pass
     */

    @RequestMapping(path = "user", method = RequestMethod.GET)
    public String getUser(){
       return username + ","  + ", " + password;
    };

}
