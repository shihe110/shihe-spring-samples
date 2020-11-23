package org.shihe.listener;

import org.shihe.event.Event;
import org.shihe.event.EventObject;
import org.shihe.pojo.Order;

/**
 * @ClassName OrderEventListener
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 14:39
 * @Version 1.0
 */
public class OrderEventListener extends AbstractEventListener{
    public OrderEventListener(int order) {
        super(order);
    }

    @Override
    public void onEvent(Event event) {
        // 获取监听对象
        EventObject eventObject = event.getEventObject();
        Order order = (Order) eventObject.getObject();
        // 后续业务处理
        System.out.println(order.getOrderNo());
    }

}
