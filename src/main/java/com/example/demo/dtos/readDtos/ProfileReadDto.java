package com.example.demo.dtos.readDtos;

import java.util.List;

public record ProfileReadDto(
    int id,
    String codeProfile,
    String label,
    List<AccountUserReadDto> accounts,
    List<PermissionReadDto> permissions
) {}
