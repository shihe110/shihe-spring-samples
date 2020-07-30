package org.shihe.service;

import org.shihe.aop.Action;
import org.springframework.stereotype.Service;

/**
 * @ClassName DemoAnnotationService
 * @Description 注解式拦截
 * @Author admin
 * @Date 2020-07-30 15:25
 * @Version 1.0
 */
@Service
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add(){}
}
