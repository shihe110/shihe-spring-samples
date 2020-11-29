package org.shihe.event;

import java.util.List;

/**
 * @ClassName EventMutilcaster
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 9:49
 * @Version 1.0
 */
public class EventMutilcaster {
    private List<AbstractEventListener> listeners;

    public EventMutilcaster(List<AbstractEventListener> listeners) {
        this.listeners = listeners;
    }

    /**
     * 广播
     * @param event
     */
    public void mutilcasEvent(Event event){
        for (AbstractEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
