package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import com.example.demo.dtos.readDtos.PermissionReadDto;
import com.example.demo.dtos.writeUpdateDtos.PermissionWriteDto;
import com.example.demo.entities.Permission;

@Mapper
public class PermissionMapper {
    public static Permission toEntity(PermissionWriteDto permissionWriteDto){
        if (permissionWriteDto == null) return null;
        Permission permission = new Permission();
        BeanUtils.copyProperties(permissionWriteDto, permission);
        return permission;
    }

    public static PermissionReadDto toDto(Permission permission){
        if (permission == null) return null;
        return new PermissionReadDto(
            permission.getId(),
            permission.getCodePermission(),
            permission.getLabel(),
            ProfileMapper.toDto(permission.getProfile())
        );
    }

    public static List<PermissionReadDto> toDtoList(List<Permission> permissions) {
        if (permissions == null) return null;
        return permissions.stream().map(PermissionMapper::toDto).collect(Collectors.toList());
    }
}
