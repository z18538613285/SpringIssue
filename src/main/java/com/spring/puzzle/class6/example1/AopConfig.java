package com.spring.puzzle.class6.example1;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/***
 *
 * 同一个切面中，不同类型的增强方法被调用的
 * 顺序依次为 Around.class, Before.class, After.class, AfterReturning.class,
 * AfterThrowing.class。
 */

@Aspect
@Service
public class AopConfig {

    @Before("execution(* com.spring.puzzle.class6.example1.ElectricService.charge()) ")
    public void checkAuthority(JoinPoint pjp) throws Throwable {
        System.out.println("validating user authority");
        Thread.sleep(1000);
    }


    @Around("execution(* com.spring.puzzle.class6.example1.ElectricService.doCharge()) ")
    public void recordPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("charge method time cost: " + (end - start));
    }

}