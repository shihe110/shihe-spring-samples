package org.shihe.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
    // 注解本身没有功能，功能来自使用注解的地方。
}
