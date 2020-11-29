package org.shihe.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author admin
 * @Date 2020-11-03 17:17
 * @Version 1.0
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    public void hello(){
        helloService.name = "lisi";
        helloService.hello();
        System.out.println(helloService.name+"  controller");
    }
}
