package io.yodo.springcourse.aspectjdemo.dao;

import io.yodo.springcourse.aspectjdemo.AccountRepository;

public interface MembershipDAO {

    String addAccount(String name);

    void setAccountRepository(AccountRepository repo);
}
