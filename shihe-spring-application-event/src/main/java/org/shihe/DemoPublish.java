package org.shihe;

import org.shihe.bean.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName DemoPublish
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:20
 * @Version 1.0
 */
@Component
public class DemoPublish {

    @Autowired
    private ApplicationContext context;

    public void publish(String msg){
        context.publishEvent(new DemoEvent(this,msg));
    }
}
