package me.ohnena.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary //EventService타입 빈은 이걸로 Autowired받게 된다. AppRunner에서 이걸로 테스트하려면 @Primary를 활성화하면 되겠다.
@Service
public class ProxySimpleEventService implements EventService { // Proxy Pattern 사용 실습...

    @Autowired
    SimpleEventService simpleEventService;
    //EventService simpleEventService; 가능...

    @Override
    public void createEvent() {
        //long begin = System.currentTimeMillis();
        simpleEventService.createEvent();
        //System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void publishEvent() {
        //long begin = System.currentTimeMillis();
        simpleEventService.publishEvent();
        //System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();

    }
}
