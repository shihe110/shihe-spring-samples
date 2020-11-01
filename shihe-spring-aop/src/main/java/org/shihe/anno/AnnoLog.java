package org.shihe.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnoLog {

    @Before("execution(* org.shihe.service.*.*(..))")
    public void before(){
        System.out.println("注解版前置通知");
    }
}
