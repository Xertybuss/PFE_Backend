package com.example.demo.dtos.writeUpdateDtos;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class UsageWriteDto {
    private Date date_start_affectation;
    private Date date_end_affectation;
    private Time start_hour_mourning;
    private Time end_hour_mourning;
    private Time start_hour_evening;
    private Time end_hour_evening;
    private int collaborater_id;
    private int vehicle_id;
}
