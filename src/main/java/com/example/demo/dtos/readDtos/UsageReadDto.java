package com.example.demo.dtos.readDtos;

import java.sql.Time;
import java.sql.Date;

public record UsageReadDto(
    int id,
    Date dateStartAffectation,
    Date dateEndAffectation,
    Time startHourMorning,
    Time endHourMorning,
    Time startHourEvening,
    Time endHourEvening,
    CollaboraterReadDto collaborater,
    VehicleReadDto vehicle
) {}
