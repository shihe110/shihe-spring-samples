package org.shihe.listener;

import org.shihe.event.Event;
import org.shihe.event.EventObject;

/**
 * @ClassName EventListener
 * @Description 事件监听器
 * @Author admin
 * @Date 2020-11-20 14:30
 * @Version 1.0
 */
public interface EventListener {
    /**
     * 触发事件
     * @param event
     */
    void onEvent(Event event);
}
