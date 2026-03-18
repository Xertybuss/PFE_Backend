package com.example.demo.dtos.readDtos;

import java.util.List;

public record CompanyReadDto(
    int id,
    String code_company,
    String label,
    String address,
    String phone_number,
    List<VehicleReadDto> vehicles,
    List<AccountUserReadDto> accounts,
    List<CollaboraterReadDto> collaboraters
) {}
