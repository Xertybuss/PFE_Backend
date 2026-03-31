package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Permission;

public interface PermissionService {
    public List<Permission> getAllPermissions();
    public Permission getPermissionById(Integer id);
    public Permission createPermission(Permission permission);
    public Permission updatePermission(Permission permission);
    public void deletePermission(Integer id);
}
