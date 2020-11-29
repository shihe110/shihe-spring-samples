package org.shihe;

import org.shihe.event.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:25
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublish bean = context.getBean(DemoPublish.class);
        bean.publish("事件发布");

        context.close();

        /*List<AbstractEventListener> listeners = new ArrayList<>();
        listeners.add(new BusEventListener(1));
        listeners.add(new CarEventListener(2));

        EventMutilcaster eventMutilcaster = new EventMutilcaster(listeners);

        Order order = new Order("ID" + System.currentTimeMillis());
        EventObject eventObject = new EventObject(order);

        eventMutilcaster.mutilcasEvent(new OrderCallbackEvent(eventObject));*/

    }
}
