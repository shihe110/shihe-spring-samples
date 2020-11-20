package org.shihe.event;

/**
 * @ClassName AbstractEventListener
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 9:41
 * @Version 1.0
 */
public class AbstractEventListener implements EventListener{

    private int order;

    public int getOrder() {
        return order;
    }

    public AbstractEventListener(int order) {
        this.order = order;
    }

    public void onEvent(Event event) {

    }
}
