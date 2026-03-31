package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.AccountUser;

public interface AccountUserService {
    public AccountUser getAccountUserById(Integer id);
    public List<AccountUser> getAccountUsers();
    public AccountUser createAccountUser(AccountUser accountUser);
    public AccountUser updateAccountUser(AccountUser accountUser);
    public void deleteAccountUser(Integer id);
}
