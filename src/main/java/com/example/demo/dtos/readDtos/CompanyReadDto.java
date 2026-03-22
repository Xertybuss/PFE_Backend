package com.example.demo.dtos.readDtos;

import java.util.List;

public record CompanyReadDto(
    int id,
    String codeCompany,
    String label,
    String address,
    String phoneNumber,
    List<VehicleReadDto> vehicles,
    List<AccountUserReadDto> accounts,
    List<CollaboraterReadDto> collaboraters
) {}
