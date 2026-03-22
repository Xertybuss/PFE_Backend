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
    private Date dateStartAffectation;
    private Date dateEndAffectation;
    private Time startHourMorning;
    private Time endHourMorning;
    private Time startHourEvening;
    private Time endHourEvening;
    @ManyToOne(fetch = FetchType.LAZY)
    private Collaborater collaborater;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;
}
