package com.example.demo.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.AccountUserReadDto;
import com.example.demo.dtos.writeUpdateDtos.AccountUserWriteDto;
import com.example.demo.entities.AccountUser;

@Mapper
public class AccountUserMapper {
    public static AccountUser toEntity(AccountUserWriteDto accountUserWriteDto){
        if (accountUserWriteDto == null) return null;
        AccountUser accountUser = new AccountUser();
        BeanUtils.copyProperties(accountUserWriteDto, accountUser, "id");
        return accountUser;
    }

    public static AccountUserReadDto toReadDto(AccountUser accountUser){
        if (accountUser == null) return null;
        AccountUserReadDto accountUserReadDto = new AccountUserReadDto(
            accountUser.getId(),
            accountUser.getFirstName(),
            accountUser.getLastName(),
            accountUser.getUsername(),
            accountUser.getPhoneNumber(),
            accountUser.isActivated(),
            CompanyMapper.toDto(accountUser.getCompany()),
            ProfileMapper.toDto(accountUser.getProfile()),
            VehicleMapper.toDtoList(accountUser.getVehicles())
        );
        return accountUserReadDto;
    }

    public static List<AccountUserReadDto> toDtoList(List<AccountUser> accountUsers){
        if(accountUsers == null) return null;
        return accountUsers.stream().map(AccountUserMapper::toReadDto).toList();
    }
}
