package me.ohnena.demospring51;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private String data;

    public MyEvent(Object source, String data) {
        super(source);
        this.data = data;
    }

    public MyEvent(Object source) {
        super(source);
    }

    public String getData() {
        return data;
    }
}
