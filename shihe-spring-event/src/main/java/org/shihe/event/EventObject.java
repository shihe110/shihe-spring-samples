package org.shihe.event;

import java.io.Serializable;

/**
 * @ClassName EventObject
 * @Description 事件操作对象
 * @Author admin
 * @Date 2020-11-20 13:57
 * @Version 1.0
 */
public class EventObject implements Serializable {

    private Object object;

    public EventObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
