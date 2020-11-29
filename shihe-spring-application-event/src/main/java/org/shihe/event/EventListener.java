package org.shihe.event;

public interface EventListener {
    /**
     * 触发事件方法
     * @param event
     */
    void onEvent(Event event);
}
