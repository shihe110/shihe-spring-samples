package org.shihe.listener;

import org.shihe.bean.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName DemoEventListener
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:18
 * @Version 1.0
 */
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("=================="+msg+"=================");
    }
}
