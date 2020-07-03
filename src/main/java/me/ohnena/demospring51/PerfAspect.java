package me.ohnena.demospring51;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //@Around("execution(* me.ohnena..*.*(..))") //패키지 내의 모든 메소드가 pointCut이 되어버린다...
    //@Around("execution(* me.ohnena..*.EventService.*(..))") //해당 클래스의 모든 메소드가 pointCut이 되어버린다...
    @Around("@annotation(PerfLogging)") //@PerfLogging를 단 메소드만이 pointCut이 된다.
    //@Around("bean(SimpleEventService)") //해당 빈의 모든 메소드가 pointCut이 된다. <<< not working...T.T
    //@Around("execution(* me.ohnena..*.EventService.*(..))") //해당 클래스의 모든 메소드가 pointCut이 되어버린다...
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println("PerfAspect Around: ------" + (System.currentTimeMillis() - begin));
        return retVal;
    }

    //@Before("bean(SimpleEventService)") // <<< not working...T.T
    @Before("@annotation(PerfLogging)") //@PerfLogging를 단 메소드만이 pointCut이 된다.
    public void hello() {
        System.out.println("PerfAspect Before: ______Hello~!");
    }
}
