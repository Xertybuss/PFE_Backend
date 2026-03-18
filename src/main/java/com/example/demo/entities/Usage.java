package com.example.demo.entities;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usage{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date_start_affectation;
    private Date date_end_affectation;
    private Time start_hour_morning;
    private Time end_hour_morning;
    private Time start_hour_evening;
    private Time end_hour_evening;
    @ManyToOne
    private Collaborater collaborater;
    @ManyToOne
    private Vehicle vehicle;
}
