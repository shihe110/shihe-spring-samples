package org.shihe.listener;

import org.shihe.event.Event;
import org.shihe.event.EventObject;
import org.shihe.pojo.Order;

/**
 * @ClassName UserEventListener
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 14:53
 * @Version 1.0
 */
public class UserEventListener extends AbstractEventListener{
    public UserEventListener(int order) {
        super(order);
    }

    public void onEvent(Event event) {
        EventObject eventObject = event.getEventObject();
        Order order = (Order) eventObject.getObject();

        String orderNo = order.getOrderNo();
        System.out.println("User:"+orderNo);
    }
}
