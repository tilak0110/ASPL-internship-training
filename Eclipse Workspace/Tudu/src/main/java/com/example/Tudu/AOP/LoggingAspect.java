package com.example.Tudu.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.Tudu.serviceImpl.TodoServiceImpl.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(" [Before] Method called: " + methodName + ", with args: " + Arrays.toString(args));
    }

    @AfterReturning(pointcut = "execution(* com.example.Tudu.serviceImpl.TodoServiceImpl.*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("✅ [After] Method: " + methodName + " completed, returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.Tudu.serviceImpl.TodoServiceImpl.*(..))", throwing = "ex")
    public void logExceptions(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(" [Exception] in method: " + methodName + " -> " + ex.getMessage());
    }
}
