package com.example.dtos.readDtos;

import java.sql.Date;

public record TripReadDto(
    Integer id,
    String label,
    Date date_end,
    Boolean status_generated,
    double total_distance,
    int total_passengers 
) {}
