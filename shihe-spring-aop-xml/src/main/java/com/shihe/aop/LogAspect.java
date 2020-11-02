package com.shihe.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author admin
 * @Date 2020-10-30 17:25
 * @Version 1.0
 */
public class LogAspect {

    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法开始执行了...");
    }

    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法执行结束了...");
    }

    public void returing(JoinPoint joinPoint,Integer r) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法返回："+r);
    }

    public void afterThrowing(JoinPoint joinPoint,Exception e) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法抛异常了："+e.getMessage());
    }

    public Object around(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
            //这个相当于 method.invoke 方法，我们可以在这个方法的前后分别添加日志，就相当于是前置/后置通知
            System.out.println("环绕通知--方法执行前");
            proceed = pjp.proceed();
            System.out.println("环绕通知--方法执行后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
