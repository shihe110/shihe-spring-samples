package com.shihe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JAccountAdvice implements InvocationHandler {

    private IAccountService target;

    public JAccountAdvice(IAccountService target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        return method.invoke(target,args);
    }

    public void before(){
        System.out.println("验明正身");
    }
}
