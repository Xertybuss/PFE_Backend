package com.example.demo.mappers;

import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.PermissionReadDto;
import com.example.demo.dtos.writeUpdateDtos.PermissionWriteDto;
import com.example.demo.entities.Permission;

public class PermissionMapper {
    public static Permission toEntity(PermissionWriteDto permissionWriteDto){
        if(permissionWriteDto == null) return null;
        Permission permission = new Permission();
        BeanUtils.copyProperties(permissionWriteDto, permission);
        return permission;
    }

    public static PermissionReadDto toDto(Permission permission){
        if(permission == null) return null;
        PermissionReadDto permissionReadDto = new PermissionReadDto();
        BeanUtils.copyProperties(permission, permissionReadDto);
        return permissionReadDto;
    }
}
