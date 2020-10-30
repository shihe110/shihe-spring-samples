package org.shihe.springapi;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
// spring api实现aop
public class Log implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("springapi前置通知");
    }
}
