package org.shihe.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName LogAspect
 * @Description 定义切面
 * @Author admin
 * @Date 2020-07-30 15:30
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {

    // 注解式切点
    @Pointcut("@annotation(org.shihe.aop.Action)")
    public void annotationPointCut(){

    }
    // JoinPoint连接点
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 "+action.name());
    }

    @Before("execution(* org.shihe.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截，"+method.getName());
    }
}
