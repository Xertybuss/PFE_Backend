package com.example.demo.dtos.writeUpdateDtos;

import lombok.*;

@Getter @Setter
public class CollaboraterWriteDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String homeLocation;
    private String address;
    private String collabType;
    private int companyId;
}
