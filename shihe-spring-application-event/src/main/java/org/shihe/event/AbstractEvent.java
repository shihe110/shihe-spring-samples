package org.shihe.event;

/**
 * @ClassName AbstractEvent
 * @Description TODO
 * @Author admin
 * @Date 2020-11-20 9:29
 * @Version 1.0
 */
public class AbstractEvent implements Event {

    private static final long serialVersionUID = 4565465456465656465L;

    private long timestamp;

    private EventObject eventObject;

    public AbstractEvent(EventObject eventObject) {
        this.setEventObject(eventObject);
    }

    public EventObject getEventObject() {
        return eventObject;
    }

    public void setEventObject(EventObject eventObject) {
        this.eventObject = eventObject;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
