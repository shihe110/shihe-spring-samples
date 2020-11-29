package org.shihe.event;

import java.io.Serializable;

/**
 * 事件接口
 */
public interface Event extends Serializable {

    /**
     * 获取事件对象
     * @return
     */
    EventObject getEventObject();

    /**
     * 设置事件操作对象
     * @param eventObject
     */
    void setEventObject(EventObject eventObject);
}
