package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AccountUser;
import com.example.demo.repositories.AccountUserRepository;
import com.example.demo.services.AccountUserService;

@Service
public class AccountUserServiceImpl implements AccountUserService{
    private AccountUserRepository accountUserRepository;

    public AccountUserServiceImpl(AccountUserRepository accountUserRepository){
        this.accountUserRepository = accountUserRepository;
    }

    @Override
    public AccountUser getAccountUserById(Integer id) {
        return accountUserRepository.findAccountUserById(id);
    }

    @Override
    public List<AccountUser> getAccountUsers() {
        return accountUserRepository.findAll();
    }

    @Override
    public AccountUser createAccountUser(AccountUser accountUser) {
        return accountUserRepository.save(accountUser);
    }

    @Override
    public AccountUser updateAccountUser(AccountUser accountUser) {
        AccountUser existingAccountUser = accountUserRepository.findAccountUserById(accountUser.getId());
        BeanUtils.copyProperties(accountUser, existingAccountUser, "id");
        return accountUserRepository.save(existingAccountUser);
    }

    @Override
    public void deleteAccountUser(Integer id) {
        accountUserRepository.deleteById(id);
    }
}
