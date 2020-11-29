package org.shihe.event;

/**
 * @ClassName 事件对象
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 9:26
 * @Version 1.0
 */
public class EventObject {

    private Order o;

    public EventObject(Order o) {
        this.o = o;
    }

    public Order getO() {
        return o;
    }
}
