package io.yodo.springcourse.aspectjdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(50)
public class DaoLoggingAspect {

    @Before("DaoExpressions.publicNonSetterDaoMethod()")
    public void loggingAdvice(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println(">> @Before [100] Logging a method that shall be calleth with arguments " + Arrays.toString(args));
    }
}
