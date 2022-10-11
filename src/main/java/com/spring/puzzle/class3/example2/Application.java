package com.spring.puzzle.class3.example2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
/*
    @Order(2)
*/
    public Student student1(){
        return createStudent(1, "xie");
    }

    @Bean
/*    @Order(1)*/
    public Student student2(){
        return createStudent(2, "fang");
    }

    /***
     *这两种装配集合的方式是不能同存的，结合本案例，当使用收集装配方式来装配
     * 时，能找到任何一个对应的 Bean，则返回，如果一个都没有找到，才会采用直接装配的方
     * 式。
     *
     * ：在对于同一个集合对象的注入上，混合多种注入方
     * 式是不可取的，这样除了错乱，别无所得。
     */

    @Bean
    public List<Student> students(){
        Student student3 = createStudent(3, "liu");
        Student student4 = createStudent(4, "fu");
        return Arrays.asList(student3, student4);
    }
/*    @Bean
    public Student student3(){
        return createStudent(3, "liu");
    }

    @Bean
    public Student student4(){
        return createStudent(4, "fu");
    }*/

    private Student createStudent(int id, String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        return student;
    }



}
