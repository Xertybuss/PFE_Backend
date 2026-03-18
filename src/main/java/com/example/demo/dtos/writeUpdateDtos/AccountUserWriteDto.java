package com.example.demo.dtos.writeUpdateDtos;

import lombok.Data;

@Data
public class AccountUserWriteDto {
    private String first_name;
    private String last_name;
    private String phone_number;
    private String address;
    private String type_collab;
    private int company_id;
    private int profile_id;
}
