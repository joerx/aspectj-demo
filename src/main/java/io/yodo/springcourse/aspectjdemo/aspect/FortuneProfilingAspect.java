package io.yodo.springcourse.aspectjdemo.aspect;

import io.yodo.springcourse.aspectjdemo.service.UnfortunateException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class FortuneProfilingAspect {

    private static Logger log = Logger.getLogger(FortuneProfilingAspect.class.getName());

    @Around("execution(public * io.yodo.springcourse.aspectjdemo.service.FortuneService.*(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint pjp) throws Throwable {
        Object result;

        long start = System.currentTimeMillis();

        try {
            result = pjp.proceed(pjp.getArgs());
        } catch (UnfortunateException ex) {
            result = ex.getMessage();
        } catch (Throwable t) {
            log.warning("Around advice caught exception " + t);
            throw t;
        }

        long stop = System.currentTimeMillis();
        long delta = (stop - start);

        log.info("Execution of " + pjp.getSignature().toShortString() + " took " + delta + " ms");

        return result;
    }
}
