package org.shihe.listener;

import org.shihe.event.Event;

/**
 * @ClassName AbstractEventListener
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 14:32
 * @Version 1.0
 */
public abstract class AbstractEventListener implements EventListener{

    private int order;

    public AbstractEventListener(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public void onEvent(Event event) {

    }
}
