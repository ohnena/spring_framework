package me.ohnena.demospring51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class Demospring51Application {

    public static void main(String[] args) {

        SpringApplication.run(Demospring51Application.class, args);

//        // 편의상 빠른 실행을 위해 아래와 같은 코드를 생성...>>> ConversionService못찾아서 취소...
//        SpringApplication app = new SpringApplication(Demospring51Application.class);
//        app.setWebApplicationType(WebApplicationType.NONE);
//        app.run(args);

    }
    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3);
        return messageSource;
    }

}
