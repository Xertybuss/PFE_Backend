package com.example.demo.dtos.writeUpdateDtos;

import lombok.Data;

@Data
public class CollaboraterWriteDto {
    private String first_name;
    private String last_name;
    private String phone_number;
    private String home_location;
    private String address;
    private String collab_type;
    private int company_id;
}
