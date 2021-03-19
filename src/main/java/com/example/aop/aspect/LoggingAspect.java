package com.example.aop.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.aop.controller..*(..)))")
    public Object logControllerLevel(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        LOGGER.info("Controller level: " + methodSignature.getDeclaringType().getSimpleName() + "."
                + methodSignature.getName() + " " + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }

    @Around("execution(* com.example.aop.service..*(..)))")
    public Object logServiceLevel(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        LOGGER.info("Service level: " + methodSignature.getDeclaringType().getSimpleName() + "."
                + methodSignature.getName() + " " + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }


    @Around("execution(* com.example.aop.dao..*(..)))")
    public Object logDAOLevel(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        LOGGER.info("DAO level: " + methodSignature.getDeclaringType().getSimpleName() + "."
                + methodSignature.getName() + " " + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }
}
