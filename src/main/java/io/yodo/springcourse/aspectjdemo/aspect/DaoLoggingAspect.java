package io.yodo.springcourse.aspectjdemo.aspect;

import io.yodo.springcourse.aspectjdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
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

    @After("DaoExpressions.publicNonSetterDaoMethod()")
    public void afterFinallyLoggingAdvice(JoinPoint jp) {
        Signature sig = jp.getSignature();
        System.out.println("<< @After [" + ORDER + "] Logging " + sig.toShortString() + " has finally completed");
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
