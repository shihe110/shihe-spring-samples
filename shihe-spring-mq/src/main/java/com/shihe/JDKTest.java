package com.shihe;

import java.lang.reflect.Proxy;

public class JDKTest {
    public static void main(String[] args) {
        IAccountService target = new AccountService();

        IAccountService o = (IAccountService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new JAccountAdvice(target));
        o.transfer();
    }
}
