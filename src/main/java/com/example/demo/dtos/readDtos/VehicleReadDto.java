package com.example.demo.dtos.readDtos;

import java.util.List;

public record VehicleReadDto(
    int id,
    String imei,
    String immatriculation,
    String label,
    String vehicle_type,
    int capacity_places,
    double capacity_weight,
    double company_id,
    int account_user_id,
    List<UsageReadDto> usages
) {}
