package me.ohnena.demospring51;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//아래와 같이 모두 빈으로 등록가능. 포매터나 컨버터 모두, 고전적인 방식인 PropertyEditor와는 다르게 Thread-safe하기때문...
public class OutEventConverter {
    @Component
    public static class StringToOurEventConverter implements Converter<String, OurEvent> {
        @Override
        public OurEvent convert(String source) {
            return new OurEvent(Integer.parseInt(source));
        }

    }
//    @Component
    public static class OurEventToStringConverter implements Converter<OurEvent, String> {
        @Override
        public String convert(OurEvent source) {
            return source.getId().toString();
        }
    }

}
