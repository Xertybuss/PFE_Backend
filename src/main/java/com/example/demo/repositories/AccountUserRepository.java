package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AccountUser;

public interface AccountUserRepository extends JpaRepository<AccountUser, Integer>{

}
