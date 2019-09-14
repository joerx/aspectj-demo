package io.yodo.springcourse.aspectjdemo.aspect;

import io.yodo.springcourse.aspectjdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(100)
public class DaoLoggingAspect {

    @Before("DaoExpressions.publicNonSetterDaoMethod()")
    public void beforeLoggingAdvice(JoinPoint jp) {
        Signature sig = jp.getSignature();
        Object[] args = jp.getArgs();
        System.out.println(">> @Before [100] Logging " + sig.toShortString() + " to be called with arguments " + Arrays.toString(args));
    }

    @AfterReturning("DaoExpressions.publicNonSetterDaoMethod()")
    public void afterReturningAuditingAdvice(JoinPoint jp) {
        Signature sig = jp.getSignature();
        System.out.println(">> @AfterReturning [100] Logging " + sig.toShortString() + " has returned");
    }
}
