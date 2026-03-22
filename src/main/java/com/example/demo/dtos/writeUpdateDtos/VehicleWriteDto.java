package com.example.demo.dtos.writeUpdateDtos;

import lombok.*;

@Getter @Setter
public class VehicleWriteDto {
    private String imei;
    private String immatriculation;
    private String label;
    private String vehicleType;
    private int capacityPlaces;
    private double capacityWeight;
    private int company_id;
}
