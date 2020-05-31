package me.ohnena.demospring51;

import org.springframework.context.event.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    @Async
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("Another: " + myEvent.getData());
        System.out.println(Thread.currentThread().getName());
    }

    @EventListener
    @Async
    public void onApplicationEvent2(ContextRefreshedEvent event) {
        System.out.println(event.toString());
        //System.out.println(Thread.currentThread().getName());
    }
    @EventListener
    @Async
    public void onApplicationEvent2(ContextClosedEvent event) {
        System.out.println(event.toString());
        //System.out.println(Thread.currentThread().getName());
    }
    @EventListener
    @Async
    public void onApplicationEvent2(ContextStartedEvent event) {
        System.out.println(event.toString());
        //System.out.println(Thread.currentThread().getName());
    }
    @EventListener
    @Async
    public void onApplicationEvent2(ContextStoppedEvent event) {
        System.out.println(event.toString());
        //System.out.println(Thread.currentThread().getName());
    }
}

