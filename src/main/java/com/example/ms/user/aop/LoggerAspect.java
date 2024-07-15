package com.example.ms.user.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class LoggerAspect {
    @Pointcut("@annotation(com.example.ms.user.annotation.LogAnnotation)")
    public void setLog() {
    }

    @SneakyThrows
    @Around(value = "setLog()")
    public Object logAround(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("ActionLog start of {}", methodName);
        var result = joinPoint.proceed();
        log.info("ActionLog end of {}", methodName);
        return result;
    }
}
