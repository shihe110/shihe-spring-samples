package org.shihe.event;

import java.io.Serializable;

/**
 * @ClassName Event
 * @Description 定义事件接口
 * @Author admin
 * @Date 2020-11-20 9:24
 * @Version 1.0
 */
public interface Event extends Serializable {
    /**
     * 获取事件对象
     * @return
     */
    EventObject getEventObject();

    /**
     * 设置事件持有的数据对象
     * @param eventObject
     */
    void setEventObject(EventObject eventObject);
}
