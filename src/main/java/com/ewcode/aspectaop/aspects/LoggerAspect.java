package com.ewcode.aspectaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    @Before("@annotation(com.ewcode.aspectaop.annotations.LogExecutionTime)")
    public void logExecutionTimeBefore() throws Throwable {
        final String preffix = "logExecutionTime -> BEFORE";
        logger.info(preffix + " -> STARTING");

        Thread.sleep(43L);

        logger.info(preffix + " -> FINISHED");
    }

    @Around("@annotation(com.ewcode.aspectaop.annotations.LogExecutionTime)")
    public Object logExecutionTimeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        final String preffix = "logExecutionTime -> AROUND";
        logger.info(preffix + " -> STARTING");

        Thread.sleep(43L);

        Object proceed = joinPoint.proceed();

        logger.info(preffix + " -> FINISHED");
        return proceed;
    }

    @After("@annotation(com.ewcode.aspectaop.annotations.LogExecutionTime)")
    public void logExecutionTimeAfter() throws Throwable {
        final String preffix = "logExecutionTime -> AFTER";
        logger.info(preffix + " -> STARTING");
        Thread.sleep(43L);
        logger.info(preffix + " -> FINISHED");
    }
}
