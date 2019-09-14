package io.yodo.springcourse.aspectjdemo.dao;

import io.yodo.springcourse.aspectjdemo.AccountRepository;
import io.yodo.springcourse.aspectjdemo.entity.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account);

    List<Account> findAccounts();

    void setAccountRepository(AccountRepository repo);
}
