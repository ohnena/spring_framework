package me.ohnena.demospring51;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    @Async
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println(myEvent.getData());
        System.out.println(Thread.currentThread().getName());
    }
}
