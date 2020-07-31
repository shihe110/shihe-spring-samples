package org.shihe.bean;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName DemoEvent
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:15
 * @Version 1.0
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
