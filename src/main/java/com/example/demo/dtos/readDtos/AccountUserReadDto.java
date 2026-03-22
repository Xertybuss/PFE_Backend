package com.example.demo.dtos.readDtos;

import java.util.List;

public record AccountUserReadDto(
    int id,
    String firstName,
    String lastName,
    String username,
    String phoneNumber,
    boolean activated,
    CompanyReadDto company,
    ProfileReadDto profile,
    List<VehicleReadDto> vehicles
) {}
