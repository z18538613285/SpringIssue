package com.spring.puzzle.class1.example1.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *而一旦显式指定其它包，原来的默认扫描包就被忽略了。
 */

@SpringBootApplication
@ComponentScan("com.spring.puzzle.class1.example1.controller")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
