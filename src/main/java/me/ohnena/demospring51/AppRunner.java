package me.ohnena.demospring51;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;


@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    MessageSource messageSource;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    ResourceLoader resourceLoader; //ApplicationContext다...

    @Value("${app.name}")
    String name;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("A.Profiles::: " + Arrays.toString(ctx.getEnvironment().getActiveProfiles()));
//        System.out.println("D.Profiles::: " + Arrays.toString(ctx.getEnvironment().getDefaultProfiles()));
//        System.out.println("app.name::: " + ctx.getEnvironment().getProperty("app.name"));
//        System.out.println(name);
//        System.out.println(ctx.getBeanDefinitionNames());
//        System.out.println(messageSource.getClass());
//        System.out.println(ctx.getMessage("greeting", new String[]{"Seung"}, Locale.KOREA));
//        System.out.println(messageSource.getMessage("greeting", new String[]{"Seung"}, Locale.getDefault()));

//        System.out.println(ctx.getClass());
//        System.out.println(messageSource.getClass());
//        System.out.println(eventPublisher.getClass());
//        eventPublisher.publishEvent(new MyEvent(this, "Seu Jorge"));

        System.out.println(resourceLoader.getClassLoader());

        Resource resource = resourceLoader.getResource("test.txt");
        System.out.println(resource.getClass());
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());

        resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println(resource.getClass());
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());


    }
}
