package com.example.demo.dtos.writeUpdateDtos;

import lombok.Data;

@Data
public class PermissionWriteDto {
    private String code_permission;
    private String label;
    private int profile_id;
}
