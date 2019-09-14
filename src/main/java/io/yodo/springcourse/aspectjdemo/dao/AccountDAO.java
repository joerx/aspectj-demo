package io.yodo.springcourse.aspectjdemo.dao;

import io.yodo.springcourse.aspectjdemo.AccountRepository;

public interface AccountDAO {

    void addAccount(String name, boolean isVip);

    void setAccountRepository(AccountRepository repo);
}
