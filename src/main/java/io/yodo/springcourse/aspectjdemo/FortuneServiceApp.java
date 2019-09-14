package io.yodo.springcourse.aspectjdemo;

import io.yodo.springcourse.aspectjdemo.aspect.FortuneProfilingAspect;
import io.yodo.springcourse.aspectjdemo.service.FortuneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@SuppressWarnings("TryFinallyCanBeTryWithResources")
public class FortuneServiceApp {

    private static Logger log = Logger.getLogger(FortuneServiceApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectJDemoConfig.class);

        try {
            FortuneService s = ctx.getBean(FortuneService.class);

            String f1 = s.getFortune(10);
            log.info("Got fortune \"" + f1 + "\"");

            String f2 = s.getFortune(13);
            log.info("Got fortune \"" + f2 + "\"");

            String f3 = s.getFortune(40);
            log.info("Got fortune \"" + f3 + "\"");

        } catch (Exception e) {
            log.warning("Main app caught " + e);
        } finally {
            ctx.close();
        }
    }
}
