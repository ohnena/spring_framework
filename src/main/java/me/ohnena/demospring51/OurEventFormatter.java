package me.ohnena.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


//
// 컨버터와 포매터는 그냥 이렇게 빈으로만 등록하면, 데이터바인딩작업을 알아서 하는 것으로 배웠다.
// 그런데 테스트에서 포매터만 작동을 안한다. (WebConfig로 혹은 @WebMvcTest로 직접 등록해주면 작동을 한다)
//
@Component //빈으로 등록가능. 컨버터도, 포매터도 모두 고전적인 방식인 PropertyEditor와는 다르게 Thread-safe하기때문이다.
public class OurEventFormatter implements Formatter<OurEvent> {

//    @Autowired
//    MessageSource messageSource; //i18N을 위한 메시지소스빈빈 사용능...

    @Override
    public OurEvent parse(String text, Locale locale) throws ParseException {
        return new OurEvent(Integer.parseInt(text));
    }

    @Override
    public String print(OurEvent ourEvent, Locale locale) {
        return ourEvent.getId().toString();
    }
}