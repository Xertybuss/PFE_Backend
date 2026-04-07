package com.example.demo.controllers;

import com.example.demo.dtos.readDtos.AccountUserReadDto;
import com.example.demo.dtos.writeUpdateDtos.AccountUserWriteDto;
import com.example.demo.mappers.AccountUserMapper;
import com.example.demo.services.AccountUserService;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account_users")
public class AccountUserController {
    private AccountUserService accountUserService;

    public AccountUserController(AccountUserService accountUserService){
        this.accountUserService = accountUserService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<AccountUserReadDto> getAllAccountUsers() {
        return AccountUserMapper.toDtoList(accountUserService.getAccountUsers());
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/get/{id}")
    public AccountUserReadDto getAccountUserById(@PathVariable Integer id) {
        return AccountUserMapper.toReadDto(accountUserService.getAccountUserById(id));
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/create")
    public AccountUserReadDto createAccountUser(@RequestBody AccountUserWriteDto entity) {
        return AccountUserMapper.toReadDto(accountUserService.createAccountUser(AccountUserMapper.toEntity(entity)));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/update")
    public AccountUserReadDto updateAccountUser(@RequestBody AccountUserWriteDto entity) {
        return AccountUserMapper.toReadDto(accountUserService.updateAccountUser(AccountUserMapper.toEntity(entity)));   
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteAccountUser(@PathVariable Integer id){
        accountUserService.deleteAccountUser(id);
    }
}
