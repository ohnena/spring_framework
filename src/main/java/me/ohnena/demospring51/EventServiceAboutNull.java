package me.ohnena.demospring51;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EventServiceAboutNull {

    /**
     *
     * argument, return_value 둘다 NonNull...
     */
    @NonNull
    public String createEvent(@NonNull String name) {
        //return null;
        System.out.println("Null-Safety Test..."+name);
        return "Hello~ "+name;
    }

}
