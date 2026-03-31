package com.example.demo.services.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Permission;
import com.example.demo.repositories.PermissionRepository;
import com.example.demo.services.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{
    private PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository){
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermissionById(Integer id) {
        return permissionRepository.findPermissionById(id);
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission updatePermission(Permission permission) {
        Permission existingPermission = permissionRepository.findPermissionById(permission.getId());
        BeanUtils.copyProperties(permission, existingPermission, "id");
        return permissionRepository.save(existingPermission);
    }

    @Override
    public void deletePermission(Integer id) {
        permissionRepository.deleteById(id);
    }
}
