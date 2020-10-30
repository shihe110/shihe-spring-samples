package org.shihe.custom;

public class CustomLog {

    public void beforeLog(){
        System.out.println("zi定义前置log");
    }

    public void afterLog(){
        System.out.println("zi定义后置log");
    }
}
