package org.shihe.muticaster;

import org.shihe.event.Event;
import org.shihe.listener.AbstractEventListener;

import java.util.List;

/**
 * @ClassName EventMutilcaster
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 14:34
 * @Version 1.0
 */
public class EventMutilcaster {

    private List<AbstractEventListener> listeners;

    public EventMutilcaster(List<AbstractEventListener> listeners) {
        this.listeners = listeners;
    }

    public void mutilCaster(Event event){
        for (AbstractEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
