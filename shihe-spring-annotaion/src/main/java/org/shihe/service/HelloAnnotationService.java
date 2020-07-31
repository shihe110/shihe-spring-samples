package org.shihe.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloAnnotationService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 15:46
 * @Version 1.0
 */
@Service
public class HelloAnnotationService {

    public void output(){
        System.out.println("从组合注解获取该bean");
    }
}
