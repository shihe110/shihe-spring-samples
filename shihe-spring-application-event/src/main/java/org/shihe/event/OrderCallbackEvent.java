package org.shihe.event;

/**
 * @ClassName OrderCallbackEvent
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 9:35
 * @Version 1.0
 */
public class OrderCallbackEvent extends AbstractEvent{
    private static final long serialVersionUID = 45654654565765465L;
    public OrderCallbackEvent(EventObject eventObject) {
        super(eventObject);
    }
}
