package com.example.demo.dtos.readDtos;

public record PermissionReadDto(
    int id,
    String codePermission,
    String label,
    ProfileReadDto profile
) {}
