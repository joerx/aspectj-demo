package io.yodo.springcourse.aspectjdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("io.yodo.springcourse.aspectjdemo")
public class AspectJDemoConfig {
}
