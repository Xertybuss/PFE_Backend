package com.example.demo.dtos.readDtos;

import java.sql.Time;
import java.sql.Date;

public record UsageReadDto(
    int id,
    Date date_start_affectation,
    Date date_end_affectation,
    Time start_hour_morning,
    Time end_hour_morning,
    Time start_hour_evening,
    Time end_hour_evening,
    int collaborater_id,
    int vehicle_id
) {}
