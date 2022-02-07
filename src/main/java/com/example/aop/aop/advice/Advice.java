package com.example.aop.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class Advice {
    @Before("@annotation(com.example.aop.aop.cutpoint.BeforeCutPoint)")
    public void beforeCutPoint(JoinPoint joinPoint){
        System.out.println("before cut point!");
    }
    @After("@annotation(com.example.aop.aop.cutpoint.AfterCutPoint)")
    public void afterCutPoint(JoinPoint joinPoint){
        System.out.println("after cut point!");
    }
    @AfterReturning(value="@annotation(com.example.aop.aop.cutpoint.AfterReturnCutPoint)",returning="result")
    public void afterReturnCutPoint(JoinPoint joinPoint,Object result){
        System.out.println("after cut point!");
        System.out.println("result:"+result.toString());
    }
    @Around("@annotation(com.example.aop.aop.cutpoint.AroundCutPoint)")
    public Object aroundCutPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("processing method....");
            var result = joinPoint.proceed();
            System.out.println("proceed over");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
    }
}
