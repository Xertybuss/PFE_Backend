package com.example.demo.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public abstract class Dates {
    private Date date_creation;
    private Date date_update;
}
