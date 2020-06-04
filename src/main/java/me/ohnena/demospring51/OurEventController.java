package me.ohnena.demospring51;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OurEventController {       //데이터바인딩 공부...

    //
    // PropertyEditor 자동 등록 방법...
    //
//    @InitBinder
//    public void init(WebDataBinder webDataBinder) {
//        //PropertyEditor가 ThreadSafe하지 않아서 빈으로 등록하는 건 위험...이렇게 사용하자.
//        webDataBinder.registerCustomEditor(OurEvent.class, new OurEventEditor());
//    }

    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable OurEvent event) {
        System.out.println(event + " <<<<<< DataBinding Result!");
        return event.getId().toString();
    }
}
