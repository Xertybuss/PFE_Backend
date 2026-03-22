package com.example.demo.dtos.readDtos;

import java.util.List;

public record CollaboraterReadDto(
    int id,
    String firstName,
    String lastName,
    String phoneNumber,
    String homeLocation,
    String address,
    String collabType,
    CompanyReadDto company,
    List<UsageReadDto> usages
) {}