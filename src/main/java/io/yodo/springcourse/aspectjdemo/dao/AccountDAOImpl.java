package io.yodo.springcourse.aspectjdemo.dao;

import io.yodo.springcourse.aspectjdemo.AccountRepository;
import org.springframework.stereotype.Component;

// Note: can use final here because we code against an interface and AspectJ will proxy against the interface instead
@Component
public final class AccountDAOImpl implements AccountDAO {

    private AccountRepository accountRepository;

    public void addAccount(String name, boolean isVip) {
        System.out.println(getClass() + ": doing some important database work to add an Account named " + name);
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        System.out.println((getClass() + ": account repo has been set"));
        this.accountRepository = accountRepository;
    }
}
