package io.yodo.springcourse.aspectjdemo;

import io.yodo.springcourse.aspectjdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectJDemoConfig.class);

        try {
            AccountDAO accountDAO = ctx.getBean(AccountDAO.class);
            AccountRepository repo = ctx.getBean(AccountRepository.class);

            System.out.println(accountDAO.getClass());
            System.out.println();

            accountDAO.setAccountRepository(repo);
            accountDAO.addAccount("johndoe", false);

        } finally {
            ctx.close();
        }
    }
}
