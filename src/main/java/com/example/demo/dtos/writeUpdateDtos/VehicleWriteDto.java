package com.example.demo.dtos.writeUpdateDtos;

import lombok.Data;

@Data
public class VehicleWriteDto {
    private String imei;
    private String immatriculation;
    private String label;
    private String vehicle_type;
    private int capacity_places;
    private double capacity_weight;
    private int company_id;
}
