package com.example.demo.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.readDtos.PermissionReadDto;
import com.example.demo.dtos.writeUpdateDtos.PermissionWriteDto;
import com.example.demo.mappers.PermissionMapper;
import com.example.demo.services.PermissionService;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private PermissionService permissionService;

    public PermissionController(PermissionService permissionService){
        this.permissionService = permissionService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all")
    public List<PermissionReadDto> getAllPermissions() {
        return PermissionMapper.toDtoList(permissionService.getAllPermissions());
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/get/{id}")
    public PermissionReadDto getPermission(@PathVariable Integer id) {
        return PermissionMapper.toDto(permissionService.getPermissionById(id));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/create")
    public PermissionReadDto createPermission(@RequestBody PermissionWriteDto entity) {
        return PermissionMapper.toDto(permissionService.createPermission(PermissionMapper.toEntity(entity)));
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update")
    public PermissionReadDto putMethodName(@RequestBody PermissionWriteDto entity) {
        return PermissionMapper.toDto(permissionService.updatePermission(PermissionMapper.toEntity(entity)));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deletePermission(@PathVariable Integer id){
        permissionService.deletePermission(id);
    }
}
