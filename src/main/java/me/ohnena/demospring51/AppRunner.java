package me.ohnena.demospring51;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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
    LocalValidatorFactoryBean validator;
    //    Validator validator;


    //SpEL
    @Value("#{1+1}")
    int sum;

    @Value("#{'Hello' + 'Man'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean isEqual;

    @Value("${my.value}")           //프로퍼티. application.properties에 지정한 값...
    int myproperty;

    @Value("${app.name}")
    String myproperty2;

    @Value("#{${my.value} eq 100}")  //프로퍼티를 이용한 연산도 가능 (반대는 불가)
    boolean mypropertyEq100;

    @Value("#{sample.data}")        // 직접 만든 Sample빈으로부터...
    int dataFromBean;




    @Autowired
    ConversionService conversionService; //컨버터,포매터를 이용한 데이터 바인딩 용..

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


        //
        // #14 DataBinding(2/2) Converter,Formatter
        //
        // OurEventConverter, OurEventFormatter, WebConfig 등 참고...
//        System.out.println(conversionService.getClass().toString());
//        System.out.println(conversionService);


        //
        // #15 SpEL (Spring EL, Spring Expression Language)
        // 이외에도 메소드 호출방법도 있다고 (문서참고)
        System.out.println("=========================");
        System.out.println(sum);
        System.out.println(greeting);
        System.out.println(isEqual);
        System.out.println(myproperty);         // 프로퍼티 (application.properties에 지정한 값...)
        System.out.println(myproperty2);
        System.out.println(mypropertyEq100);    // 프로퍼티에 연산을...
        System.out.println(dataFromBean);       // 빈으로부터..

        //에노테이션을 이용하지 않고, 아래와 같이 ExpressionParser를 직접 이용할 수 있다
        //ExpressionParser는 SpEL의 구성요소 중 하나이다.
        //@Value가 내부적으로 이렇게 구현되는 것인듯.
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("2 + 5");
        Integer value = expression.getValue(Integer.class);    //내부적으로는 conversionService가 작동하여 데이터바인딩이 이루어진다고...
        System.out.println(value);

    }
}
