package com.example.Spring_AOP.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoginAspectV2 {
    @Before("allServiceMethodPointCut")
    public void beforeServiceMethodCalls(JoinPoint joinPoint){
        log.info("Before advice method call,{}",joinPoint.getSignature());

    }
    @After("allServiceMethodPointCut")
    public void afterServiceMethodCalls(JoinPoint joinPoint){
        log.info("After advice method call,{}",joinPoint.getSignature());

    }
    @Pointcut("execution(com.example.Spring_AOP.services.impl.*.*(..)")
    public void allServiceMethodPointCut(){

    }
}
