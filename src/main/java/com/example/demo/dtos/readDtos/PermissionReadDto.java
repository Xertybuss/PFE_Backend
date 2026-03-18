package com.example.demo.dtos.readDtos;

public record PermissionReadDto(
    int id,
    String code_permission,
    String label,
    int profile_id
) {}
