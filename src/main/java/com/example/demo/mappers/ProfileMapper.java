package com.example.demo.mappers;

import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.ProfileReadDto;
import com.example.demo.dtos.writeUpdateDtos.ProfileWriteDto;
import com.example.demo.entities.Profile;

public class ProfileMapper {
    public static Profile toEntity(ProfileWriteDto profileWriteDto){
        if(profileWriteDto == null) return null;
        Profile profile = new Profile();
        BeanUtils.copyProperties(profileWriteDto, profile);
        return profile;
    }

    public static ProfileReadDto toDto(Profile profile){
        if(profile == null) return null;
        return new ProfileReadDto(
            profile.getId(),
            profile.getCodeProfile(),
            profile.getLabel(),
            AccountUserMapper.toDtoList(profile.getAccounts()),
            PermissionMapper.toDtoList(profile.getPermissions())
        );
    }
}
