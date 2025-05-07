package com.example.jeera_.practice.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.jeera_.practice.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(">>> Calling: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.jeera_.practice.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("<<< Completed: " + joinPoint.getSignature().getName());
    }
}
