package io.yodo.springcourse.aspectjdemo.aspect;

import io.yodo.springcourse.aspectjdemo.entity.Account;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(InjectSuperUserAspect.ORDER)
public class InjectSuperUserAspect {

    // Note: for @AfterReturning order is reversed
    static final int ORDER = 400;

    @AfterReturning(
            pointcut = "execution(* io.yodo.springcourse.aspectjdemo.dao.*.findAccounts(..))",
            returning = "result"
    )
    public void injectSuperUserAccountAdvice(List<Account> result) {
        System.out.println(">> @AfterReturning [" + ORDER + "] Injecting super user");
        result.add(new Account("john", true));
    }
}
