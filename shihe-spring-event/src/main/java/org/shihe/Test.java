package org.shihe;

import org.shihe.event.EventObject;
import org.shihe.event.CallbackEvent;
import org.shihe.listener.AbstractEventListener;
import org.shihe.listener.OrderEventListener;
import org.shihe.listener.UserEventListener;
import org.shihe.muticaster.EventMutilcaster;
import org.shihe.pojo.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 14:42
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

        List<AbstractEventListener> listeners = new ArrayList<AbstractEventListener>();
        listeners.add(new OrderEventListener(1));
        listeners.add(new UserEventListener(2));

        EventMutilcaster eventMutilcaster = new EventMutilcaster(listeners);
        Order order = new Order("orderNo" + System.currentTimeMillis());
        CallbackEvent orderCallbackEvent = new CallbackEvent(new EventObject(order));

        eventMutilcaster.mutilCaster(orderCallbackEvent);

    }
}
