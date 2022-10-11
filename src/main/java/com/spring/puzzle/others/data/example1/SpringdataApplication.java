package com.spring.puzzle.others.data.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


/*
should uncomment the dependency and related code in pom.xml
<!--        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>-->
 */

@SpringBootApplication
public class SpringdataApplication {
/**
 *
 * 就是检查自己所有的数据操作，是否使用了相同的
 * RedisTemplate，就是相同，也要检查所指定的各种 Serializer 是否完全一致，否则就会
 * 出现各式各样的错误。
 */

    SpringdataApplication(RedisTemplate redisTemplate,
                          StringRedisTemplate stringRedisTemplate){
        String key = "mykey";
        stringRedisTemplate.opsForValue().set(key, "myvalue");

        Object valueGotFromStringRedisTemplate = stringRedisTemplate.opsForValue().get(key);
        System.out.println(valueGotFromStringRedisTemplate);

        Object valueGotFromRedisTemplate = redisTemplate.opsForValue().get(key);
        System.out.println(valueGotFromRedisTemplate);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

}