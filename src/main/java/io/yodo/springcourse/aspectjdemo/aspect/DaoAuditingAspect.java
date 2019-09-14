package io.yodo.springcourse.aspectjdemo.aspect;

import io.yodo.springcourse.aspectjdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(200)
public class DaoAuditingAspect {

    @Before("DaoExpressions.publicNonSetterDaoMethod()")
    public void auditingAdvice(JoinPoint jp) {
        Signature sig = jp.getSignature();
        System.out.println(">> @Before [200] Auditing " + sig + " shall be calleth");
    }

    @AfterReturning(
            pointcut = "DaoExpressions.publicNonSetterDaoMethod()",
            returning = "result"
    )
    public void afterReturningAuditingAdvice(JoinPoint jp, List<Account> result) {
        Signature sig = jp.getSignature();
        System.out.println(">> @AfterReturning [200] Auditing " + sig.toShortString() + " has returned " + result);
    }
}
