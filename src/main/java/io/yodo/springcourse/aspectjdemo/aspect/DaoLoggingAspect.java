package io.yodo.springcourse.aspectjdemo.aspect;

import io.yodo.springcourse.aspectjdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
@Order(DaoLoggingAspect.ORDER)
public class DaoLoggingAspect {

    static final int ORDER = 100;

    @Before("DaoExpressions.publicNonSetterDaoMethod()")
    public void beforeLoggingAdvice(JoinPoint jp) {
        Signature sig = jp.getSignature();
        Object[] args = jp.getArgs();
        System.out.println(">> @Before [" + ORDER + "] Logging " + sig.toShortString() + " to be called with arguments " + Arrays.toString(args));
    }

    @AfterReturning("DaoExpressions.publicNonSetterDaoMethod()")
    public void afterReturningLoggingAdvice(JoinPoint jp) {
        Signature sig = jp.getSignature();
        System.out.println("<< @AfterReturning [" + ORDER + "] Logging " + sig.toShortString() + " has returned");
    }

    @AfterThrowing(
            pointcut = "DaoExpressions.publicNonSetterDaoMethod()",
            throwing = "ex"
    )
    public void afterThrowingLoggingAdvice(JoinPoint jp, Throwable ex) {
        Signature sig = jp.getSignature();
        System.out.println("xx @AfterThrowing [" + ORDER + "] Logging " + sig.toShortString() + " has thrown " + ex);
    }
}
