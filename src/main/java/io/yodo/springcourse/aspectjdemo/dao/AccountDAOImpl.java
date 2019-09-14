package io.yodo.springcourse.aspectjdemo.dao;

import io.yodo.springcourse.aspectjdemo.AccountRepository;
import io.yodo.springcourse.aspectjdemo.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Note: can use final here because we code against an interface and AspectJ will proxy against the interface instead
@Component
public final class AccountDAOImpl implements AccountDAO {

    private AccountRepository accountRepository;

    public void addAccount(Account account) {
        System.out.println(getClass() + ": doing some important database work to add an Account named " + account.getName());
    }

    @Override
    public List<Account> findAccounts() {
        System.out.println((getClass() + ": finding accounts"));
        ArrayList<Account> list = new ArrayList<>();
        list.add(new Account("lisa"));
        list.add(new Account("hans"));
        return list;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        System.out.println((getClass() + ": account repo has been set"));
        this.accountRepository = accountRepository;
    }
}
