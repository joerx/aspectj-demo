package io.yodo.springcourse.aspectjdemo;

import io.yodo.springcourse.aspectjdemo.dao.AccountDAO;
import io.yodo.springcourse.aspectjdemo.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SuppressWarnings("TryFinallyCanBeTryWithResources")
public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectJDemoConfig.class);
        try {
            runApp(ctx);
        } finally {
            ctx.close();
        }
    }

    private static void runApp(ApplicationContext ctx) {
        AccountDAO accountDAO = ctx.getBean(AccountDAO.class);
        AccountRepository repo = ctx.getBean(AccountRepository.class);

        System.out.println(accountDAO.getClass());
        System.out.println();

        accountDAO.setAccountRepository(repo);
        accountDAO.addAccount(new Account("johndoe"));

        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("Found " + accounts.size() + " account(s)");

        try {
            Account a = accountDAO.findAccount(1);
            System.out.println("Found accout " + a);

            Account a2 = accountDAO.findAccount(0);
            System.out.println("Found accout " + a2);
        } catch (Exception e) {
            System.err.println("Caught " + e);
        }

    }
}
