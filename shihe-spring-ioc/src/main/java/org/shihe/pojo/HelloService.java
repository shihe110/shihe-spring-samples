package org.shihe.pojo;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author admin
 * @Date 2020-11-03 17:16
 * @Version 1.0
 */
@Service
public class HelloService {

    public String name = "zhangsan";

    public void hello(){
        System.out.println("Hello service");
    }
}
