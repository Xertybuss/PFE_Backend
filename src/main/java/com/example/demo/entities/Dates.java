package com.example.demo.entities;

import java.sql.Date;

import lombok.*;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Dates {
    private Date dateCreation;
    private Date dateUpdate;
}
