package org.shihe.pojo;

/**
 * 静态工厂方法注入
 */
public class FactoryDog {
    public static Dog getInstence(){
        return new Dog("汪汪",5);
    }

    public Dog getInstence2(){
        return new Dog("匡匡",3);
    }
}
