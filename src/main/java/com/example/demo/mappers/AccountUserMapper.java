package com.example.demo.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.AccountUserReadDto;
import com.example.demo.dtos.writeUpdateDtos.AccountUserWriteDto;
import com.example.demo.entities.AccountUser;

@Mapper
public class AccountUserMapper {
    public static AccountUser toEntity(AccountUserWriteDto accountUserWriteDto){
        if(accountUserWriteDto == null) return null;
        AccountUser accountUser = new AccountUser();
        BeanUtils.copyProperties(accountUserWriteDto, accountUser, "id");
        return accountUser;
    }

    public static AccountUserReadDto toReadDto(AccountUser accountUser){
        if(accountUser == null) return null;
        AccountUserReadDto accountUserReadDto = new AccountUserReadDto();
        BeanUtils.copyProperties(accountUser, accountUserReadDto);
        return accountUserReadDto;
    }
}
