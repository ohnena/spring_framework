package me.ohnena.demospring51;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new OutEventConverter.StringToOurEventConverter()); //직접 만든 컨버터를 등록...
        registry.addFormatter(new OurEventFormatter());
    }
}