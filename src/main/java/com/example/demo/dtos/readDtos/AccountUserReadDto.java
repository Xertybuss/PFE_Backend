package com.example.demo.dtos.readDtos;

import java.util.List;

public record AccountUserReadDto(
    int id,
    String first_name,
    String last_name,
    String username,
    String phone_number,
    boolean activated,
    CompanyReadDto company,
    ProfileReadDto profile_id,
    List<VehicleReadDto> vehicles
) {}
