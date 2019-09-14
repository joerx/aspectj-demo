package io.yodo.springcourse.aspectjdemo.dao;

import io.yodo.springcourse.aspectjdemo.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAOImpl implements MembershipDAO {

    private AccountRepository accountRepository;

    @Override
    public String addAccount(String name) {
        System.out.println(getClass() + ": doing some important database work to add a Member");
        return null;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        System.out.println((getClass() + ": account repo has been set"));
        this.accountRepository = accountRepository;
    }
}
