package io.yodo.springcourse.aspectjdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

abstract class DaoExpressions {

    @Pointcut("execution(public * io.yodo.springcourse.aspectjdemo.dao.*.*(..))")
    void publicDaoMethod() {}

    @Pointcut("execution(public * set*(..))")
    void setter() {}

    @Pointcut("publicDaoMethod() && !setter()")
    void publicNonSetterDaoMethod() {}
}
