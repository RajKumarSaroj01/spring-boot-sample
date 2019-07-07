package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Configuration
public class QueryPerformance {

    @Around(value = "execution(* org.springframework.data.repository.CrudRepository.*(..)))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time Taken by {} is {} ms", joinPoint, timeTaken);
        return result;
    }
}
