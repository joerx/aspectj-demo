package io.yodo.springcourse.aspectjdemo;

import io.yodo.springcourse.aspectjdemo.dao.AccountDAO;
import io.yodo.springcourse.aspectjdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectJDemoConfig.class);

        try {
            AccountDAO accountDAO = ctx.getBean(AccountDAO.class);
            AccountRepository repo = ctx.getBean(AccountRepository.class);

            System.out.println(accountDAO.getClass());
            System.out.println();

            accountDAO.setAccountRepository(repo);
            accountDAO.addAccount(new Account("johndoe"));

            List<Account> accounts = accountDAO.findAccounts();
            System.out.println("Found " + accounts.size() + " account(s)");

        } finally {
            ctx.close();
        }
    }
}
