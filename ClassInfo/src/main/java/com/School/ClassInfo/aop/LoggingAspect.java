package com.School.ClassInfo.aop;

import com.School.ClassInfo.Entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Aspect
@Configuration @Slf4j
public class LoggingAspect
{
    @AfterReturning(value = "within(com.School.ClassInfo.Service.*)",returning = "value")
    void afterReturning(JoinPoint jp , List<?> value)
    {
        log.info("{} method successfully executed and returned:{}",jp.getSignature(),value);
    }

    @AfterThrowing(value = "within(com.School.ClassInfo.Service.*)",throwing= "ex")
    void afterThrowing(JoinPoint jp , Exception ex)
    {
        log.error("method throwed an exception :{}",ex.getMessage());
    }
}
