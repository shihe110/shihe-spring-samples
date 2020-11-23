package org.shihe.event;

/**
 * @ClassName AbstractEvent
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 14:18
 * @Version 1.0
 */
public abstract class AbstractEvent implements Event{

    private static final long serialVersionUID = 1099057708183571937L;

    private final long timestamp = System.currentTimeMillis();

    private EventObject eventObject;

    public AbstractEvent(EventObject eventObject) {
        setEventObject(eventObject);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public EventObject getEventObject() {
        return this.eventObject;
    }

    public void setEventObject(EventObject eventObject) {
        this.eventObject = eventObject;
    }
}
