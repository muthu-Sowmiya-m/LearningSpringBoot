package com.aop.AopExample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class HelperAspect {

        private Logger logger = LoggerFactory.getLogger(this.getClass());

        @Pointcut("within(com.aop.AopExample.Controller.*)")
        public void addPointcut(){
        }

        //Executed before whenever any method is invoked inside Service Package
        @Before("execution(* com.aop.AopExample.Service.*.*(..))")
        public void before(JoinPoint joinPoint)
        {
            logger.info("Before method invocation :{} ",joinPoint.getSignature());
        }

        @After("addPointcut()")
        public void after(JoinPoint joinPoint)
        {
            logger.info("After method invocation :{} ",joinPoint.getSignature());
        }

        @AfterReturning(value = "this(com.aop.AopExample.Service.BusinessService1)",returning = "str")
        public void afterReturning(JoinPoint joinPoint,String str)
        {
            logger.info("After -{}- invocation , it returned:{} ",joinPoint.getSignature(),str);
        }


    //Executed before and after any method invoked inside Business service2 class
    @Around("this(com.aop.AopExample.Service.BusinessService2)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before Invoking Controller :{}",joinPoint.getSignature());

        Object obj = joinPoint.proceed();

        logger.info("After Invoking Controller :{}",joinPoint.getSignature());
        return obj;
    }
}
