package io.yodo.springcourse.aspectjdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(300)
public class DaoAnalyticsAspect {

    @Before("DaoExpressions.publicNonSetterDaoMethod()")
    public void analyticsAdvice() {
        System.out.println(">> @Before [300] Analytics on a method that shall be calleth");
    }
}
