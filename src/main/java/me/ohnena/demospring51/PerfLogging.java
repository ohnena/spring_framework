package me.ohnena.demospring51;

import java.lang.annotation.*;

/**
 * 이 에노테이션을 적으면, 성능을 로깅해준다.
 */
@Documented
@Target(ElementType.METHOD)        //적용범위는 메소드...
@Retention(RetentionPolicy.CLASS)  //.class파일에도 에노테이션 정보 남는다. (어차피 디폴트...)
public @interface PerfLogging {
}
