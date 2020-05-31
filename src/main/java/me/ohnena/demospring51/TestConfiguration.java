package me.ohnena.demospring51;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
public class TestConfiguration {

    @Bean
    @Profile("test")
    public BookRepository bookRepository(){
        return new TestBookRepository();
    }
}
