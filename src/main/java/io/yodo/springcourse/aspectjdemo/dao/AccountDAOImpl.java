package io.yodo.springcourse.aspectjdemo.dao;

import io.yodo.springcourse.aspectjdemo.AccountRepository;
import io.yodo.springcourse.aspectjdemo.entity.Account;
import io.yodo.springcourse.aspectjdemo.entity.NoSuchEntityException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Note: can use final here because we code against an interface and AspectJ will proxy against the interface instead
@Component
public final class AccountDAOImpl implements AccountDAO {

    private AccountRepository accountRepository;

    @Override
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

    @Override
    public Account findAccount(int accountId) {
        if (accountId < 1) {
            throw new NoSuchEntityException("No account with id " + accountId);
        }
        return new Account("mechthild");
    }

    @Override
    public void setAccountRepository(AccountRepository accountRepository) {
        System.out.println((getClass() + ": account repo has been set"));
        this.accountRepository = accountRepository;
    }
}
