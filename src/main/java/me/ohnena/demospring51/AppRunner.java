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
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

    @Autowired
    Validator validator;

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


        //
        // #10 Resource Abstraction
        //
//        System.out.println(resourceLoader.getClassLoader());
//
//        Resource resource = resourceLoader.getResource("test.txt");
//        System.out.println(resource.getClass());
//        System.out.println(resource.exists());
//        System.out.println(resource.getDescription());
//
//        resource = resourceLoader.getResource("classpath:test.txt");
//        System.out.println(resource.getClass());
//        System.out.println(resource.exists());
//        System.out.println(resource.getDescription());


        //
        // #12 Validation Abstraction
        //
        Event event = new Event();
        event.setLimit(-1);
        event.setEmail("ooo");
        //EventValidator eventValidator = new EventValidator();
        Errors errors = new BeanPropertyBindingResult(event, "event");

        //eventValidator.validate(event, errors);
        validator.validate(event, errors); // LocalValidatorFactoryBean 빈을 사용하여 validation...

        System.out.println(errors.hasErrors());
        errors.getAllErrors().forEach(e -> {
            System.out.println("====== error code ======");
            Arrays.stream(e.getCodes()).forEach(System.out::println);   //에러코드 모두 출력...
            System.out.println(e.getDefaultMessage());                  //디폴트 메시지 출력...
        });

        //주의!) 스프링 2.3부터 LocalValidatorFactoryBean를 디폴트로 제공하지 않는다.
        //      프로젝트 생성시 artifact로 스프링validator를 추가하거나, 아니면 pom.xml에서 의존성으로 추가해야한다.
        System.out.println(validator.getClass());



        //
        // #13 DataBinding(1/2) PropertyEditor
        //
        // OurEventControllerTest 참고.

    }
}
