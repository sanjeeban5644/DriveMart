package com.sanjeeban.DriveMart.Aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Match all methods in all classes inside Controllers package
    @Before("execution(* com.sanjeeban.DriveMart.Controllers.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("Before Method Execution: {}", joinPoint.getSignature().toShortString());
    }

    @Around("execution(* com.sanjeeban.DriveMart.Controllers.*.*(..))")
    public Object logBeforeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long starTime = System.currentTimeMillis();
        logger.info("Before Method Execution: {}", joinPoint.getSignature().toShortString());

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        logger.info("Time taken ms : {}",endTime-starTime);
        logger.info("After Method execution : {}",joinPoint.getSignature().toShortString());

        return result;
    }



}
