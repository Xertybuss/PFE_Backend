package com.example.demo.dtos.readDtos;

import java.util.List;

public record VehicleReadDto(
    int id,
    String imei,
    String immatriculation,
    String label,
    String vehicleType,
    int capacityPlaces,
    double capacityWeight,
    CompanyReadDto company,
    AccountUserReadDto accountUser,
    List<UsageReadDto> usages
) {}
